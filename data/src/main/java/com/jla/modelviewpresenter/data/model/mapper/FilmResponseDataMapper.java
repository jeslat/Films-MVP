package com.jla.modelviewpresenter.data.model.mapper;

import com.jla.modelviewpresenter.data.model.FilmResponse;
import com.jla.modelviewpresenter.data.model.ImagesResponse;
import com.jla.modelviewpresenter.domain.model.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmResponseDataMapper {

    public static Film transform(FilmResponse filmResponse, ImagesResponse imagesResponse) {
        Film film = new Film();
        film.setAdult(filmResponse.isAdult());
        film.setBackdropPath(filmResponse.getBackdropPath());
        film.setId(filmResponse.getId());
        film.setOriginalTitle(filmResponse.getOriginalTitle());
        film.setReleaseDate(filmResponse.getReleaseDate());
        film.setPosterPath(filmResponse.getPosterPath());
        film.setPopularity(filmResponse.getPopularity());
        film.setTitle(filmResponse.getTitle());
        film.setVoteAverage(filmResponse.getVoteAverage());
        film.setVoteCount(filmResponse.getVoteCount());
        film.setPosterUrl(createPosterUrl(film.getPosterPath(), imagesResponse));
        film.setLargePosterUrl(createLargePosterUrl(film.getPosterPath(), imagesResponse));
        return film;
    }

    public static List<Film> transform(List<FilmResponse> filmResponses, ImagesResponse imagesResponse) {
        List<Film> films = new ArrayList<>();
        for (FilmResponse filmResponse : filmResponses){
            films.add(transform(filmResponse, imagesResponse));
        }
        return films;
    }

    private static String createPosterUrl(String posterPath, ImagesResponse imagesResponse) {
        return imagesResponse.getSecure_base_url() + imagesResponse.getPoster_sizes()[1] + posterPath;
    }

    private static String createLargePosterUrl(String posterPath, ImagesResponse imagesResponse) {
        return imagesResponse.getSecure_base_url() + imagesResponse.getPoster_sizes()[3] + posterPath;
    }
}
