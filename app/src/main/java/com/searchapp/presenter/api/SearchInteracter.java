package com.searchapp.presenter.api;

import android.app.ProgressDialog;
import android.text.TextUtils;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.searchapp.listeners.ISearchInteracter;
import com.searchapp.listeners.OnSearchFinishedListener;
import com.searchapp.modle.RestResponse;
import com.searchapp.modle.Result;
import com.searchapp.modle.SearchResponse;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sandeep Tiwari on 11/9/2016.
 */

public class SearchInteracter implements ISearchInteracter {

    private OnSearchFinishedListener listener;
    private ApiManager api;


    public SearchInteracter(){

        Retrofit retrofit = getRetrofitClient();

        // prepare call in Retrofit 2.0
        api = retrofit.create(ApiManager.class);
    }

    @Override
    public void searchQuery(OnSearchFinishedListener listener, String queryString) {
        this.listener = listener;

        Call<SearchResponse> call = api.getSearchResult(queryString);

        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                try {
                    if (response.code() == 200) {
                        RestResponse restResponse = response.body().getRestResponse();
                        List<Result> results = restResponse.getResult();
                        SearchInteracter.this.listener.onSuccess(results);
                    } else {

                    }
                } catch (Exception e) {
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                SearchInteracter.this.listener.onError();
            }
        });
    }


    public Retrofit getRetrofitClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        // okHttpClient.interceptors().add(new DecryptedPayloadInterceptor(this));
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://services.groupkt.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
