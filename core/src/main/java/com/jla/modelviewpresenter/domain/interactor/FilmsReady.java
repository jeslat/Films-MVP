package com.jla.modelviewpresenter.domain.interactor;

import com.jla.modelviewpresenter.domain.model.Film;

import java.util.List;

public class FilmsReady {

    private List<Film> films;

    public FilmsReady(List<Film> films) {
        this.films = films;
    }

    public List<Film> getFilms() {
        return films;
    }
}
