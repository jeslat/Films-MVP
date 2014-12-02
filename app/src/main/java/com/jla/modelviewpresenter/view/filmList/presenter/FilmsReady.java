package com.jla.modelviewpresenter.view.filmList.presenter;

import com.jla.modelviewpresenter.data.entity.Film;

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
