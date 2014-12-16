package com.jla.modelviewpresenter.domain.job;

import com.jla.modelviewpresenter.domain.bus.MainThreadBus;
import com.jla.modelviewpresenter.domain.interactor.FilmsReady;
import com.jla.modelviewpresenter.domain.model.Film;
import com.jla.modelviewpresenter.domain.repository.FilmRepository;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.List;

public class GetPopularFilmsJob extends Job {

    private static final String TAG = "GetPopularFilmsJob";
    private static final int PRIORITY = 1;

    private FilmRepository filmRepository;
    private MainThreadBus mainThreadBus;

    public GetPopularFilmsJob(FilmRepository filmRepository, MainThreadBus mainThreadBus) {
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
