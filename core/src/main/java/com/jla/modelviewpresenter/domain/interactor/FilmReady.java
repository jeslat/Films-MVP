package com.jla.modelviewpresenter.domain.interactor;

import com.jla.modelviewpresenter.domain.model.Film;

public class FilmReady {

    Film film;

    public FilmReady(Film film) {
        this.film = film;
    }

    public Film getFilm() {
        return film;
    }
}
