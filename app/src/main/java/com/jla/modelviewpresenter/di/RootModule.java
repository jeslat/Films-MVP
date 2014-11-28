package com.jla.modelviewpresenter.di;

import android.content.Context;

import com.jla.modelviewpresenter.MVPApplication;
import com.squareup.otto.Bus;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = MVPApplication.class,
        library = true)
public class RootModule {

    private final Context applicationContext;

    public RootModule(Context context) {
        this.applicationContext = context;
    }

    @Provides
    @Named("ApplicationContext")
    public Context provideApplicationContext() {
        return applicationContext;
    }

    @Provides
    @Singleton
    public Bus provideBus() {
        return new Bus();
    }
}
