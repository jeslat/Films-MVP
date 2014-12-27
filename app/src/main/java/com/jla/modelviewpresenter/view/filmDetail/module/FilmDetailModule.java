package com.jla.modelviewpresenter.view.filmDetail.module;

import android.content.Context;

import com.jla.modelviewpresenter.data.dataStore.film.FilmDataStoreFactory;
import com.jla.modelviewpresenter.data.dataStore.images.ImagesDataStoreFactory;
import com.jla.modelviewpresenter.data.repository.FilmRepositoryImpl;
import com.jla.modelviewpresenter.data.repository.PreferencesRepositoryImpl;
import com.jla.modelviewpresenter.domain.bus.MainThreadBus;
import com.jla.modelviewpresenter.domain.interactor.FindPopularFilmInteractor;
import com.jla.modelviewpresenter.domain.interactor.FindPopularFilmInteractorImpl;
import com.jla.modelviewpresenter.domain.job.FindPopularFilmJob;
import com.jla.modelviewpresenter.domain.repository.FilmRepository;
import com.jla.modelviewpresenter.domain.repository.PreferencesRepository;
import com.jla.modelviewpresenter.view.filmDetail.presenter.FilmDetailPresenter;
import com.jla.modelviewpresenter.view.filmDetail.presenter.FilmDetailPresenterImpl;
import com.jla.modelviewpresenter.view.filmDetail.view.FilmDetailActivity;
import com.jla.modelviewpresenter.view.filmDetail.view.FilmDetailView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = FilmDetailActivity.class,
        library = true,
        complete = false)
public class FilmDetailModule {

    private FilmDetailView view;

    public FilmDetailModule(FilmDetailView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    public FilmDetailView provideView() {
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
    public FindPopularFilmJob provideFindPopularFilmJob(FilmRepository filmRepository, MainThreadBus mainThreadBus) {
        return new FindPopularFilmJob(filmRepository, mainThreadBus);
    }

    @Provides
    public FindPopularFilmInteractor provideFindPopularFilmInteractor(final FindPopularFilmInteractorImpl findPopularFilmInteractor) {
        return findPopularFilmInteractor;
    }

    @Provides
    @Singleton
    public FilmDetailPresenter providePresenter(final FilmDetailPresenterImpl presenter) {
        return presenter;
    }
}
