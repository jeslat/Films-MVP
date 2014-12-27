package com.jla.modelviewpresenter.view.filmDetail.presenter;

import android.net.Uri;

import com.jla.modelviewpresenter.domain.bus.MainThreadBus;
import com.jla.modelviewpresenter.domain.interactor.FilmReady;
import com.jla.modelviewpresenter.domain.interactor.FindPopularFilmInteractor;
import com.jla.modelviewpresenter.domain.model.Film;
import com.jla.modelviewpresenter.view.filmDetail.view.FilmDetailView;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

public class FilmDetailPresenterImpl implements FilmDetailPresenter {

    @Inject
    MainThreadBus bus;
    @Inject
    FindPopularFilmInteractor findPopularFilmInteractor;
    @Inject
    FilmDetailView view;

    @Override
    public void onResume(int id) {
        bus.register(this);
        findPopularFilmInteractor.findPopularFilm(id);
    }

    @Override
    public void onPause() {
        bus.unregister(this);
    }

    @Subscribe
    public void filmAvailable(FilmReady filmReady){
        Film film = filmReady.getFilm();
        view.setPicture(Uri.parse(film.getPosterUrl()));
        view.setTitle(film.getTitle());
        view.setReleaseDate(film.getReleaseDate());
        view.setVoteAverage(String.valueOf(film.getVoteAverage()));
        view.setVoteCount(String.valueOf(film.getVoteCount()));
    }
}
