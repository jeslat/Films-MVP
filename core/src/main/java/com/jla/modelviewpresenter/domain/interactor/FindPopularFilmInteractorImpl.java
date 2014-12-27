package com.jla.modelviewpresenter.domain.interactor;

import com.jla.modelviewpresenter.domain.job.FindPopularFilmJob;
import com.path.android.jobqueue.JobManager;

import javax.inject.Inject;

public class FindPopularFilmInteractorImpl implements FindPopularFilmInteractor {

    @Inject
    JobManager jobManager;
    @Inject
    FindPopularFilmJob findPopularFilmJob;

    @Override
    public void findPopularFilm(int id) {
        findPopularFilmJob.setId(id);
        jobManager.addJob(findPopularFilmJob);
    }
}
