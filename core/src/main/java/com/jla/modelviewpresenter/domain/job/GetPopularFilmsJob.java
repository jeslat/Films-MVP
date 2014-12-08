package com.jla.modelviewpresenter.domain.job;

import android.util.Log;

import com.jla.modelviewpresenter.data.entity.Film;
import com.jla.modelviewpresenter.data.repository.FilmRepository;
import com.jla.modelviewpresenter.domain.bus.MainThreadBus;
import com.jla.modelviewpresenter.domain.interactor.FilmsReady;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.ArrayList;
import java.util.List;

import retrofit.RetrofitError;

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
