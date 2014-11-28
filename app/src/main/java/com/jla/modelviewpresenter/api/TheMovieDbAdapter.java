package com.jla.modelviewpresenter.api;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class TheMovieDbAdapter {

    private static final String ENDPOINT = "https://api.themoviedb.org/3";

    public TheMovieDbService create() {
        return new RestAdapter.Builder()
                .setEndpoint(ENDPOINT)
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TheMovieDbService.class);
    }
}
