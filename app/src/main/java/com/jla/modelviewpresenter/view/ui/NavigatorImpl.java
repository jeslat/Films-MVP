package com.jla.modelviewpresenter.view.ui;

import android.app.Activity;
import android.content.Intent;

import com.jla.modelviewpresenter.view.filmDetail.view.FilmDetailActivity;

public class NavigatorImpl implements Navigator {

    public static final String FILM_ID = "id";

    private Activity activityContext;

    public NavigatorImpl(Activity activity) {
        activityContext = activity;
    }

    @Override
    public void navigateToDetail(int filmId) {
        Intent intent = new Intent(activityContext, FilmDetailActivity.class);
        intent.putExtra(FILM_ID, filmId);
        activityContext.startActivity(intent);
    }
}
