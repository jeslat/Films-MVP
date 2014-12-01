package com.jla.modelviewpresenter.domain.interactor;

import com.jla.modelviewpresenter.data.repository.FilmRepositoryImpl;
import com.jla.modelviewpresenter.domain.model.Film;
import com.jla.modelviewpresenter.domain.repository.FilmRepository;
import com.jla.modelviewpresenter.view.util.MainThreadBus;
import com.jla.modelviewpresenter.view.filmList.presenter.FilmsReady;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.List;

public class GetPopularFilmsInteractor extends Job {

    private static final int PRIORITY = 1;
    //private FilmRepository filmRepository;

    public GetPopularFilmsInteractor(FilmRepository filmRepository) {
        super(new Params(PRIORITY).requireNetwork().persist());
        //this.filmRepository = filmRepository;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        FilmRepository filmRepository = new FilmRepositoryImpl();
        List<Film> popularFilms = filmRepository.getPopularFilms();
        MainThreadBus.getInstance().post(new FilmsReady(popularFilms));
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return false;
    }
}
