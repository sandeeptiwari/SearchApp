package com.searchapp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.searchapp.R;
import com.searchapp.modle.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by GUR38618 on 11/9/2016.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{

    private List<Result> items;
    private Context context;

    public SearchAdapter(Context context, List<Result> items) {
        this.context = context;
        this.items = items;

    }


    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_search, parent, false);

        SearchViewHolder myViewHolder = new SearchViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        Result result = items.get(position);
        holder.txtCountry.setText(result.getCountry());
        holder.txtName.setText(result.getName());
        holder.txtAbbr.setText(result.getAbbr());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class SearchViewHolder
            extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_country) TextView txtCountry;
        @BindView(R.id.txt_name) TextView txtName;
        @BindView(R.id.txt_abbr) TextView txtAbbr;

        public SearchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
