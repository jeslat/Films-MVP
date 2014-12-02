package com.jla.modelviewpresenter.domain.interactor;

import android.util.Log;

import com.jla.modelviewpresenter.data.repository.FilmRepositoryImpl;
import com.jla.modelviewpresenter.domain.model.Film;
import com.jla.modelviewpresenter.domain.repository.FilmRepository;
import com.jla.modelviewpresenter.view.bus.MainThreadBus;
import com.jla.modelviewpresenter.view.bus.MainThreadBusImpl;
import com.jla.modelviewpresenter.view.filmList.presenter.FilmsReady;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit.RetrofitError;

public class GetPopularFilmsInteractor extends Job {

    private static final int PRIORITY = 1;
    private static final String TAG = "GetPopularFilmsInteractor";

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
        List<Film> popularFilms;

        try {
            popularFilms = filmRepository.getPopularFilms();
        } catch (RetrofitError error) {
            Log.d(TAG, error.getResponse().getReason());
            popularFilms = new ArrayList<>();
        }

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
