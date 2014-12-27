package com.jla.modelviewpresenter.view.filmDetail.view;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jla.modelviewpresenter.R;
import com.jla.modelviewpresenter.view.filmDetail.module.FilmDetailModule;
import com.jla.modelviewpresenter.view.filmDetail.presenter.FilmDetailPresenter;
import com.jla.modelviewpresenter.view.ui.BaseActivity;
import com.jla.modelviewpresenter.view.ui.Navigator;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;

public class FilmDetailActivity extends BaseActivity implements FilmDetailView {

    @InjectView(R.id.iv_picture)
    ImageView ivPicture;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.tv_release_date)
    TextView tvReleaseDate;
    @InjectView(R.id.tv_vote_average)
    TextView tvVoteAverage;
    @InjectView(R.id.tv_vote_count)
    TextView tvVoteCount;

    @Inject
    FilmDetailPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.film_detail_activity);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume(getIntent().getExtras().getInt(Navigator.FILM_ID));
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected List<Object> getModules() {
        List<Object> modules = new ArrayList<>();
        modules.add(new FilmDetailModule(this));
        return modules;
    }

    @Override
    public void setPicture(Uri uri) {
        Picasso.with(this).load(uri).into(ivPicture);
    }

    @Override
    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void setReleaseDate(String releaseDate) {
        tvReleaseDate.setText(releaseDate);
    }

    @Override
    public void setVoteAverage(String voteAverage) {
        tvVoteAverage.setText(voteAverage);
    }

    @Override
    public void setVoteCount(String voteCount) {
        tvVoteCount.setText(voteCount);
    }
}
