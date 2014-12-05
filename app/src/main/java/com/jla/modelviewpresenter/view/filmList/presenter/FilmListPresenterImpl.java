package com.jla.modelviewpresenter.view.filmList.presenter;

import com.jla.modelviewpresenter.domain.interactor.PopulatePopularFilmsInteractor;
import com.jla.modelviewpresenter.view.bus.MainThreadBus;
import com.jla.modelviewpresenter.view.filmList.view.FilmListView;
import com.squareup.otto.Subscribe;

public class FilmListPresenterImpl implements FilmListPresenter {

    private FilmListView filmListView;
    private PopulatePopularFilmsInteractor populatePopularFilmsInteractor;
    private MainThreadBus bus;

    public FilmListPresenterImpl(FilmListView filmListView, PopulatePopularFilmsInteractor populatePopularFilmsInteractor, MainThreadBus bus) {
        this.filmListView = filmListView;
        this.populatePopularFilmsInteractor = populatePopularFilmsInteractor;
        this.bus = bus;
        this.bus.register(this);
    }

    @Override
    public void onResume() {
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
