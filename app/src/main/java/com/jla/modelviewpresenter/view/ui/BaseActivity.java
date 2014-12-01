package com.jla.modelviewpresenter.view.ui;

import android.app.Activity;
import android.os.Bundle;

import com.jla.modelviewpresenter.view.MVPApplication;
import com.jla.modelviewpresenter.view.di.ActivityModule;

import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

public abstract class BaseActivity extends Activity {

    private ObjectGraph activityScopeGraph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        injectViews();
    }

    public void inject(Object object) {
        activityScopeGraph.inject(object);
    }

    protected abstract List<Object> getModules();

    private void injectDependencies() {
        MVPApplication mvpApplication = (MVPApplication) getApplication();
        List<Object> activityScopeModules = getModules();
        activityScopeModules.add(new ActivityModule(this));
        activityScopeGraph = mvpApplication.plus(activityScopeModules);
        inject(this);
    }

    private void injectViews() {
        ButterKnife.inject(this);
    }
}
