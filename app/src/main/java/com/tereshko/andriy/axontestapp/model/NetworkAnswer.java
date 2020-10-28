package com.tereshko.andriy.axontestapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andy on 27/10/20
 */
public class NetworkAnswer {
    @SerializedName("results")
    private List<Result> results;

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

}
