package com.jla.modelviewpresenter.domain.job;

import com.jla.modelviewpresenter.domain.bus.MainThreadBus;
import com.jla.modelviewpresenter.domain.interactor.FilmReady;
import com.jla.modelviewpresenter.domain.model.Film;
import com.jla.modelviewpresenter.domain.repository.FilmRepository;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

public class FindPopularFilmJob extends Job {

    private static final int PRIORITY = 1;

    private FilmRepository filmRepository;
    private MainThreadBus mainThreadBus;
    private int id;

    public FindPopularFilmJob(FilmRepository filmRepository, MainThreadBus mainThreadBus) {
        super(new Params(PRIORITY).requireNetwork());
        this.filmRepository = filmRepository;
        this.mainThreadBus = mainThreadBus;
    }

    @Override
    public void onAdded() {
    }

    @Override
    public void onRun() throws Throwable {
        Film popularFilm = filmRepository.getPopularFilm(id);
        mainThreadBus.post(new FilmReady(popularFilm));
    }

    @Override
    protected void onCancel() {
    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }

    public void setId(int id) {
        this.id = id;
    }
}
