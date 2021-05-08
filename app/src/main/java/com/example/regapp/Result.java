package com.example.regapp;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("error")
    private String error;
    @SerializedName("message")
    private String message;

    public Result(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
