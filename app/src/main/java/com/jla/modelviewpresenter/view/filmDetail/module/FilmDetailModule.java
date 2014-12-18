package com.jla.modelviewpresenter.view.filmDetail.module;

import com.jla.modelviewpresenter.view.filmDetail.view.FilmDetailActivity;
import com.jla.modelviewpresenter.view.filmDetail.view.FilmDetailView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = FilmDetailActivity.class,
        library = true,
        complete = false)
public class FilmDetailModule {

    private FilmDetailView view;

    public FilmDetailModule(FilmDetailView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    public FilmDetailView provideView() {
        return view;
    }
}
