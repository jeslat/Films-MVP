package com.jla.modelviewpresenter.domain.job;

import android.util.Log;

import com.jla.modelviewpresenter.data.model.ConfigurationResponse;
import com.jla.modelviewpresenter.data.model.FilmResponse;
import com.jla.modelviewpresenter.data.repository.FilmRepository;
import com.jla.modelviewpresenter.domain.bus.MainThreadBus;
import com.jla.modelviewpresenter.domain.interactor.FilmsReady;
import com.jla.modelviewpresenter.domain.model.Film;
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
        List<Film> popularFilms = new ArrayList<>();
        List<FilmResponse> popularFilmsResponse;
        ConfigurationResponse configurationResponse;

        try {
            popularFilmsResponse = filmRepository.getPopularFilms();
            configurationResponse = filmRepository.getConfiguration();
        } catch (RetrofitError error) {
            Log.d(TAG, error.getResponse().getReason());
            popularFilmsResponse = new ArrayList<>();
            configurationResponse = null;
        }

        if (configurationResponse != null) {
            for (FilmResponse filmResponse : popularFilmsResponse) {
                Film film = new Film();
                film.setAdult(filmResponse.isAdult());
                film.setBackdrop_path(filmResponse.getBackdropPath());
                film.setId(filmResponse.getId());
                film.setOriginal_title(filmResponse.getOriginalTitle());
                film.setRelease_date(filmResponse.getReleaseDate());
                film.setPoster_path(filmResponse.getPosterPath());
                film.setPopularity(filmResponse.getPopularity());
                film.setTitle(filmResponse.getTitle());
                film.setVote_average(filmResponse.getVoteAverage());
                film.setVote_count(filmResponse.getVoteCount());
                film.setPoster_url(createPosterUrl(filmResponse, configurationResponse));
                popularFilms.add(film);
            }
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

    private String createPosterUrl(FilmResponse filmResponse, ConfigurationResponse configurationResponse) {
        return configurationResponse.getImages().getSecure_base_url() + configurationResponse.getImages().getPoster_sizes()[1] + filmResponse.getPosterPath();
    }
}
