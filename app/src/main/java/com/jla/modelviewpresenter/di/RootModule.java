package com.jla.modelviewpresenter.di;

import android.content.Context;

import com.jla.modelviewpresenter.MVPApplication;

import javax.inject.Named;

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
    Context provideApplicationContext() {
        return applicationContext;
    }
}
