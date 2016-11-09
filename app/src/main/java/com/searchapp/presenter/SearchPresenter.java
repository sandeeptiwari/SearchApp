package com.searchapp.presenter;

import android.app.ProgressDialog;
import android.content.Context;

import com.searchapp.listeners.ISearchView;
import com.searchapp.listeners.ISearchPresenter;
import com.searchapp.listeners.OnSearchFinishedListener;
import com.searchapp.modle.Result;
import com.searchapp.presenter.api.SearchInteracter;

import java.util.List;

/**
 * Created by Sandeep Tiwari on 11/9/2016.
 */

public class SearchPresenter implements ISearchPresenter, OnSearchFinishedListener{

    private SearchInteracter searchInteracter;
    private ISearchView iSearchView;
    private Context context;
    private ProgressDialog progressDialog;

    public SearchPresenter(Context context, ISearchView iSearchView){
        searchInteracter = new SearchInteracter();
        this.iSearchView = iSearchView;
        this.context = context;

    }

    @Override
    public void searchQuery(String query) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
        searchInteracter.searchQuery(this, query);
    }

    @Override
    public void onError() {
        progressDialog.hide();
    }

    @Override
    public void onSuccess(List<Result> results) {
        progressDialog.hide();
        iSearchView.onSearchFound(results);
    }
}
