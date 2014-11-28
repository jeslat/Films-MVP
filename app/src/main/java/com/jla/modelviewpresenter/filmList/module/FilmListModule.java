package com.jla.modelviewpresenter.filmList.module;

import com.jla.modelviewpresenter.filmList.interactor.FilmListInteractor;
import com.jla.modelviewpresenter.filmList.interactor.FilmListInteractorImpl;
import com.jla.modelviewpresenter.filmList.presenter.FilmListPresenter;
import com.jla.modelviewpresenter.filmList.presenter.FilmListPresenterImpl;
import com.jla.modelviewpresenter.filmList.view.FilmListActivity;
import com.jla.modelviewpresenter.filmList.view.FilmListView;
import com.jla.modelviewpresenter.ui.Navigator;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = FilmListActivity.class,
        library = true,
        complete = false)
public class FilmListModule {

    private FilmListView view;

    public FilmListModule(FilmListView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    public FilmListView provideView() {
        return view;
    }

    @Provides
    public FilmListInteractor provideFilmListInteractor(Bus bus) {
        return new FilmListInteractorImpl(bus);
    }

    @Provides
    @Singleton
    public FilmListPresenter providePresenter(FilmListView filmListView, FilmListInteractor filmListInteractor, Navigator navigator, Bus bus) {
        return new FilmListPresenterImpl(filmListView, filmListInteractor, navigator, bus);
    }
}
