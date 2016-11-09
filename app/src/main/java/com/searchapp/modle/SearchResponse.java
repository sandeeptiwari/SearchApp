package com.searchapp.modle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sandep Tiwari on 11/9/2016.
 */

public class SearchResponse implements Serializable{
    @SerializedName("RestResponse")
    @Expose
    RestResponse restResponse;

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }
}
