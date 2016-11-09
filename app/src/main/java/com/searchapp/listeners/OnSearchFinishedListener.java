package com.searchapp.listeners;

import com.searchapp.modle.Result;

import java.util.List;

/**
 * Created by Sandeep Tiwari on 11/9/2016.
 */

public interface OnSearchFinishedListener {

    void onError();
    void onSuccess(List<Result> results);
}
