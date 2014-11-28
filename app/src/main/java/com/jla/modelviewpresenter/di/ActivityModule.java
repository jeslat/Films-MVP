package com.jla.modelviewpresenter.di;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Named("ActivityContext")
    public Context provideActivityContext() {
        return activity;
    }
}
