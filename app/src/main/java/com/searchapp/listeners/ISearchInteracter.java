package com.searchapp.listeners;

/**
 * Created by Sandeep Tiwari on 11/9/2016.
 */

public interface ISearchInteracter {

    void searchQuery(OnSearchFinishedListener listener, String queryString);
}
