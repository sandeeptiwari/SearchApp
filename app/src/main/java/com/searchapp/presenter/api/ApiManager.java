package com.searchapp.presenter.api;

import com.searchapp.modle.SearchResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Sandeep Tiwari on 11/9/2016.
 */
public interface ApiManager {
    //@FormUrlEncoded
    //@POST("/api/user")
    //Call<CreateUserResponse> createUser(@Header("Authorization") String token, @Field("role") String role);


    @GET("state/search/IND")
    Call<SearchResponse> getSearchResult(@Query("text") String text);
}

