package com.jla.modelviewpresenter.filmList.presenter;

import com.jla.modelviewpresenter.filmList.interactor.FilmListInteractor;
import com.jla.modelviewpresenter.filmList.view.FilmListView;
import com.jla.modelviewpresenter.ui.Navigator;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class FilmListPresenterImpl implements FilmListPresenter {

    private FilmListView filmListView;
    private FilmListInteractor filmListInteractor;
    private Navigator navigator;
    private Bus bus;

    public FilmListPresenterImpl(FilmListView filmListView, FilmListInteractor filmListInteractor, Navigator navigator, Bus bus) {
        this.filmListView = filmListView;
        this.filmListInteractor = filmListInteractor;
        this.navigator = navigator;
        this.bus = bus;
        this.bus.register(this);
    }

    @Override
    public void onResume() {
        filmListView.showProgress();
        filmListInteractor.getFilmsList();
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
