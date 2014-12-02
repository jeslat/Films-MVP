package com.jla.modelviewpresenter.domain.interactor;

import com.jla.modelviewpresenter.data.repository.FilmRepositoryImpl;
import com.jla.modelviewpresenter.domain.model.Film;
import com.jla.modelviewpresenter.domain.repository.FilmRepository;
import com.jla.modelviewpresenter.view.bus.MainThreadBus;
import com.jla.modelviewpresenter.view.bus.MainThreadBusImpl;
import com.jla.modelviewpresenter.view.filmList.presenter.FilmsReady;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.List;

import javax.inject.Inject;

public class GetPopularFilmsInteractor extends Job {

    private static final int PRIORITY = 1;

    private MainThreadBus mainThreadBus;
    private FilmRepository filmRepository;

    public GetPopularFilmsInteractor(FilmRepository filmRepository, MainThreadBus mainThreadBus) {
        super(new Params(PRIORITY).requireNetwork());
        this.filmRepository = filmRepository;
        this.mainThreadBus = mainThreadBus;
    }

    @Override
    public void onAdded() {
    }

    @Override
    public void onRun() throws Throwable {
        List<Film> popularFilms = filmRepository.getPopularFilms();
        mainThreadBus.post(new FilmsReady(popularFilms));
    }

    @Override
    protected void onCancel() {
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
