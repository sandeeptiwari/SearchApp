package com.searchapp.modle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GUR38618 on 11/9/2016.
 */

public class RestResponse implements Serializable {
    @SerializedName("messages")
    @Expose
    List<String> messages = new ArrayList<String>();

    @SerializedName("result")
    @Expose
    List<Result> result = new ArrayList<Result>();


    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}
