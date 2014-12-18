package com.jla.modelviewpresenter.view.filmList.module;

import android.content.Context;

import com.jla.modelviewpresenter.data.dataStore.film.FilmDataStoreFactory;
import com.jla.modelviewpresenter.data.dataStore.images.ImagesDataStoreFactory;
import com.jla.modelviewpresenter.data.repository.FilmRepositoryImpl;
import com.jla.modelviewpresenter.data.repository.PreferencesRepositoryImpl;
import com.jla.modelviewpresenter.domain.bus.MainThreadBus;
import com.jla.modelviewpresenter.domain.interactor.PopulatePopularFilmsInteractor;
import com.jla.modelviewpresenter.domain.interactor.PopulatePopularFilmsInteractorImpl;
import com.jla.modelviewpresenter.domain.job.GetPopularFilmsJob;
import com.jla.modelviewpresenter.domain.repository.FilmRepository;
import com.jla.modelviewpresenter.domain.repository.PreferencesRepository;
import com.jla.modelviewpresenter.view.filmList.presenter.FilmListPresenter;
import com.jla.modelviewpresenter.view.filmList.presenter.FilmListPresenterImpl;
import com.jla.modelviewpresenter.view.filmList.view.FilmListActivity;
import com.jla.modelviewpresenter.view.filmList.view.FilmListView;

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
    @Singleton
    public PreferencesRepository providePreferencesRepository(Context context) {
        return new PreferencesRepositoryImpl(context);
    }

    @Provides
    @Singleton
    public ImagesDataStoreFactory provideImagesDataStoreFactory(PreferencesRepository preferencesRepository, Context context) {
        return new ImagesDataStoreFactory(preferencesRepository, context);
    }

    @Provides
    @Singleton
    public FilmDataStoreFactory provideFilmDataStoreFactory(PreferencesRepository preferencesRepository, Context context) {
        return new FilmDataStoreFactory(preferencesRepository, context);
    }

    @Provides
    @Singleton
    public FilmRepository provideFilmRepository(FilmRepositoryImpl filmRepository) {
        return filmRepository;
    }

    @Provides
    public GetPopularFilmsJob provideGetPopularFilmsJob(FilmRepository filmRepository, MainThreadBus mainThreadBus) {
        return new GetPopularFilmsJob(filmRepository, mainThreadBus);
    }

    @Provides
    public PopulatePopularFilmsInteractor providePopulatePopularFilmsInteractor(final PopulatePopularFilmsInteractorImpl populatePopularFilmsInteractor) {
        return populatePopularFilmsInteractor;
    }

    @Provides
    @Singleton
    public FilmListPresenter providePresenter(final FilmListPresenterImpl presenter) {
        return presenter;
    }
}
