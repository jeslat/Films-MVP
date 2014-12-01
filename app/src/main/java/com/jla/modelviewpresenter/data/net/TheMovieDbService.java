package com.jla.modelviewpresenter.data.net;

import com.jla.modelviewpresenter.data.entity.FilmResponse;

import retrofit.http.GET;
import retrofit.http.Query;

public interface TheMovieDbService {

    @GET("/movie/popular")
    FilmResponse getPopularMovies(@Query("api_key") String apiKey, @Query("page") int page);
}
