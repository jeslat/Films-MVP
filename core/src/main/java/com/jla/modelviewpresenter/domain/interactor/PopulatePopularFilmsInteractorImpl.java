package com.jla.modelviewpresenter.domain.interactor;

import com.jla.modelviewpresenter.domain.job.GetPopularFilmsJob;
import com.path.android.jobqueue.JobManager;

import javax.inject.Inject;

public class PopulatePopularFilmsInteractorImpl implements PopulatePopularFilmsInteractor {

    private static final String TAG = "GetPopularFilmsInteractorImpl";

    @Inject
    JobManager jobManager;
    @Inject
    GetPopularFilmsJob getPopularFilmsJob;

    @Override
    public void populatePopularFilms() {
        jobManager.addJob(getPopularFilmsJob);
    }
}
