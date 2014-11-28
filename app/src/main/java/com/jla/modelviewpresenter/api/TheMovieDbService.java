package com.jla.modelviewpresenter.api;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface TheMovieDbService {

    @GET("/movie/popular")
    Observable<FilmResponse> getPopularMovies(@Query("api_key") String apiKey, @Query("page") int page);
}
