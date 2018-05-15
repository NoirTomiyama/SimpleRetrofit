package com.tomiyama.noir.retrofit.Model;

import java.util.List;

public class APIResponse {

    private static final String TAG = APIResponse.class.getSimpleName();
    private final APIResponse self = this;

    private List<Result> results;

    public APIResponse(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
