package com.jla.modelviewpresenter.domain.interactor;

import com.jla.modelviewpresenter.domain.job.GetPopularFilmsJob;
import com.path.android.jobqueue.JobManager;

public class PopulatePopularFilmsInteractorImpl implements PopulatePopularFilmsInteractor {

    private static final String TAG = "GetPopularFilmsInteractorImpl";

    private JobManager jobManager;
    private GetPopularFilmsJob getPopularFilmsJob;

    public PopulatePopularFilmsInteractorImpl(JobManager jobManager, GetPopularFilmsJob getPopularFilmsJob) {
        this.jobManager = jobManager;
        this.getPopularFilmsJob = getPopularFilmsJob;
    }

    @Override
    public void populatePopularFilms() {
        jobManager.addJob(getPopularFilmsJob);
    }
}
