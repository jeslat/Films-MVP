package com.jla.modelviewpresenter.filmList.interactor;

import com.jla.modelviewpresenter.api.FilmResponse;
import com.jla.modelviewpresenter.api.TheMovieDbAdapter;
import com.jla.modelviewpresenter.filmList.presenter.FilmsReady;
import com.squareup.otto.Bus;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FilmListInteractorImpl implements FilmListInteractor {

    private static final String API_KEY = "20ffea664862269a108e69164352dcd8";

    private Bus bus;

    public FilmListInteractorImpl(Bus bus) {
        this.bus = bus;
    }

    @Override
    public void getFilmsList() {
        new TheMovieDbAdapter().create().getPopularMovies(API_KEY, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(filmResponse -> filmsReady(filmResponse));
    }

    private void filmsReady(FilmResponse filmResponse) {
        bus.post(new FilmsReady(filmResponse.getResults()));
    }
}
