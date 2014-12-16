package com.jla.modelviewpresenter.view.filmList.module;

import android.content.Context;

import com.jla.modelviewpresenter.data.dataStore.images.ImagesDataStoreFactory;
import com.jla.modelviewpresenter.data.dataStore.film.FilmDataStoreFactory;
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
import com.path.android.jobqueue.JobManager;

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
    public ImagesDataStoreFactory provideConfigurationDataStoreFactory(PreferencesRepository preferencesRepository, Context context) {
        return new ImagesDataStoreFactory(preferencesRepository, context);
    }

    @Provides
    @Singleton
    public FilmDataStoreFactory provideFilmDataStoreFactory(PreferencesRepository preferencesRepository, Context context) {
        return new FilmDataStoreFactory(preferencesRepository, context);
    }

    @Provides
    @Singleton
    public FilmRepository provideFilmRepository(ImagesDataStoreFactory imagesDataStoreFactory, FilmDataStoreFactory filmDataStoreFactory) {
        return new FilmRepositoryImpl(imagesDataStoreFactory, filmDataStoreFactory);
    }

    @Provides
    public GetPopularFilmsJob provideGetPopularFilmsJob(FilmRepository filmRepository, MainThreadBus mainThreadBus) {
        return new GetPopularFilmsJob(filmRepository, mainThreadBus);
    }

    @Provides
    public PopulatePopularFilmsInteractor providePopulatePopularFilmsInteractor(JobManager jobManager, GetPopularFilmsJob getPopularFilmsJob) {
        return new PopulatePopularFilmsInteractorImpl(jobManager, getPopularFilmsJob);
    }

    @Provides
    @Singleton
    public FilmListPresenter providePresenter(FilmListView filmListView, PopulatePopularFilmsInteractor populatePopularFilmsInteractor, MainThreadBus bus) {
        return new FilmListPresenterImpl(filmListView, populatePopularFilmsInteractor, bus);
    }
}
