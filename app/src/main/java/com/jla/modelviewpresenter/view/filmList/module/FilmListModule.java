package com.jla.modelviewpresenter.view.filmList.module;

import com.jla.modelviewpresenter.data.repository.FilmRepositoryImpl;
import com.jla.modelviewpresenter.domain.interactor.GetPopularFilmsInteractor;
import com.jla.modelviewpresenter.domain.repository.FilmRepository;
import com.jla.modelviewpresenter.view.filmList.presenter.FilmListPresenter;
import com.jla.modelviewpresenter.view.filmList.presenter.FilmListPresenterImpl;
import com.jla.modelviewpresenter.view.filmList.view.FilmListActivity;
import com.jla.modelviewpresenter.view.filmList.view.FilmListView;
import com.jla.modelviewpresenter.view.ui.Navigator;
import com.path.android.jobqueue.JobManager;
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
    @Singleton
    public FilmRepository provideFilmRepository() {
        return new FilmRepositoryImpl();
    }

    @Provides
    public GetPopularFilmsInteractor provideFilmListInteractor(FilmRepository filmRepository) {
        return new GetPopularFilmsInteractor(filmRepository);
    }

    @Provides
    @Singleton
    public FilmListPresenter providePresenter(FilmListView filmListView, GetPopularFilmsInteractor filmListInteractor, Navigator navigator, JobManager jobManager) {
        return new FilmListPresenterImpl(filmListView, filmListInteractor, navigator, jobManager);
    }
}
