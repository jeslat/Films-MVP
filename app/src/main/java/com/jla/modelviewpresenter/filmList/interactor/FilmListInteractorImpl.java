package com.jla.modelviewpresenter.filmList.interactor;

import com.jla.modelviewpresenter.domain.Film;
import com.jla.modelviewpresenter.filmList.presenter.FilmsReady;
import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.List;

public class FilmListInteractorImpl implements FilmListInteractor {

    private Bus bus;

    public FilmListInteractorImpl(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void getFilmsList() {
        List<Film> films = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            films.add(createRandomFilm());
        }
        bus.post(new FilmsReady(films));
    }

    private Film createRandomFilm() {
        Film film = new Film();
        film.setTitle("Film" + Math.random()*10);
        film.setYear((int) (1990 + Math.random()*10));
        return film;
    }
}
