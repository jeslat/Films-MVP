package com.jla.modelviewpresenter.view.di;

import android.app.Activity;
import android.content.Context;

import com.jla.modelviewpresenter.view.ui.Navigator;
import com.jla.modelviewpresenter.view.ui.NavigatorImpl;

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

    @Provides
    public Navigator provideNavigator() {
        return new NavigatorImpl(activity);
    }
}
