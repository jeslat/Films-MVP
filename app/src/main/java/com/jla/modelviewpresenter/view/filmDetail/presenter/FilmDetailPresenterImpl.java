package com.jla.modelviewpresenter.view.filmDetail.presenter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;

import com.jla.modelviewpresenter.R;
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
        Context context = (Activity) view;
        Film film = filmReady.getFilm();
        view.setPicture(Uri.parse(film.getLargePosterUrl()));
        view.setTitle(context.getString(R.string.title) + film.getTitle());
        view.setReleaseDate(context.getString(R.string.release_date) + film.getReleaseDate());
        view.setVoteAverage(context.getString(R.string.vote_average) + String.valueOf(film.getVoteAverage()));
        view.setVoteCount(context.getString(R.string.vote_count) + String.valueOf(film.getVoteCount()));
    }
}
