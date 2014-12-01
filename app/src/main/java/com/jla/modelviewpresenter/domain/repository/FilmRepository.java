package com.jla.modelviewpresenter.domain.repository;

import com.jla.modelviewpresenter.domain.model.Film;

import java.util.List;

public interface FilmRepository {

    public List<Film> getPopularFilms();
}
