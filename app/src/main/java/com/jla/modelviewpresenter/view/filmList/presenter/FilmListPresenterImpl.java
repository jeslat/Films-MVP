package com.jla.modelviewpresenter.view.filmList.presenter;

import com.jla.modelviewpresenter.domain.interactor.FilmsReady;
import com.jla.modelviewpresenter.domain.interactor.PopulatePopularFilmsInteractor;
import com.jla.modelviewpresenter.domain.bus.MainThreadBus;
import com.jla.modelviewpresenter.view.filmList.view.FilmListView;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

public class FilmListPresenterImpl implements FilmListPresenter {

    @Inject
    FilmListView filmListView;
    @Inject
    PopulatePopularFilmsInteractor populatePopularFilmsInteractor;
    @Inject
    MainThreadBus bus;

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
    }

    @Subscribe
    public void filmsAvailable(FilmsReady filmsReady){
        filmListView.setFilms(filmsReady.getFilms());
        filmListView.hideProgress();
    }
}
