package com.searchapp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.searchapp.R;
import com.searchapp.listeners.ISearchView;
import com.searchapp.modle.Result;
import com.searchapp.presenter.SearchPresenter;
import com.searchapp.view.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ISearchView{

    private SearchPresenter searchPresenter;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.text_empty)
    TextView txtEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /** Activity have its presenter*/
        searchPresenter = new SearchPresenter(this, this);

        searchView.setQueryHint("search your location");
        searchView.onActionViewExpanded();


        //*** setOnQueryTextFocusChangeListener ***
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

                Toast.makeText(getBaseContext(), String.valueOf(hasFocus),
                        Toast.LENGTH_SHORT).show();
            }
        });

        //*** setOnQueryTextListener ***
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                searchPresenter.searchQuery(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
    }

    @Override
    public void onSearchFound(List<Result> results) {
        // Create adapter passing in the sample user data
        if(results.size() == 0) {
            txtEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            return;
        }
        SearchAdapter searchAdapter = new SearchAdapter(this, results);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setHasFixedSize(true);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onSearchFailed() {
        txtEmpty.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }
}
