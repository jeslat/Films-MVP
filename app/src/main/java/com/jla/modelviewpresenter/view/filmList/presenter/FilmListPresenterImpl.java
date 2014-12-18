package com.jla.modelviewpresenter.view.filmList.presenter;

import android.util.Log;

import com.jla.modelviewpresenter.domain.bus.MainThreadBus;
import com.jla.modelviewpresenter.domain.interactor.FilmsReady;
import com.jla.modelviewpresenter.domain.interactor.PopulatePopularFilmsInteractor;
import com.jla.modelviewpresenter.domain.model.Film;
import com.jla.modelviewpresenter.view.filmList.view.FilmListView;
import com.jla.modelviewpresenter.view.ui.Navigator;
import com.squareup.otto.Subscribe;

import java.util.List;

import javax.inject.Inject;

public class FilmListPresenterImpl implements FilmListPresenter {

    public static final String TAG = FilmListPresenterImpl.class.getCanonicalName();

    @Inject
    FilmListView filmListView;
    @Inject
    PopulatePopularFilmsInteractor populatePopularFilmsInteractor;
    @Inject
    MainThreadBus bus;
    @Inject
    Navigator navigator;

    private List<Film> films;

    @Override
    public void onResume() {
        bus.register(this);
        filmListView.showProgress();
        populatePopularFilmsInteractor.populatePopularFilms();
    }

    @Override
    public void onPause() {
        bus.unregister(this);
    }

    @Override
    public void onItemClicked(int position) {
        Film film = films.get(position);
        Log.d(TAG, film.getTitle());
        navigator.navigateToDetail(film.getId());
    }

    @Subscribe
    public void filmsAvailable(FilmsReady filmsReady){
        films = filmsReady.getFilms();
        filmListView.setFilms(films);
        filmListView.hideProgress();
    }
}
