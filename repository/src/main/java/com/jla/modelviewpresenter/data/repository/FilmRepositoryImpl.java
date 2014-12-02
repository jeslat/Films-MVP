package com.jla.modelviewpresenter.data.repository;

import com.jla.modelviewpresenter.data.entity.Film;
import com.jla.modelviewpresenter.data.net.TheMovieDbAdapter;

import java.util.List;

public class FilmRepositoryImpl implements FilmRepository {

    private static final String API_KEY = "20ffea664862269a108e69164352dcd8";

    @Override
    public List<Film> getPopularFilms() {
        return new TheMovieDbAdapter().create().getPopularMovies(API_KEY, 1).getResults();
    }
}
