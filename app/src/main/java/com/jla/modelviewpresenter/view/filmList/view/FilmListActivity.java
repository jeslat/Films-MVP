package com.jla.modelviewpresenter.view.filmList.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.jla.modelviewpresenter.R;
import com.jla.modelviewpresenter.domain.model.Film;
import com.jla.modelviewpresenter.view.filmList.module.FilmListModule;
import com.jla.modelviewpresenter.view.filmList.presenter.FilmListPresenter;
import com.jla.modelviewpresenter.view.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;


public class FilmListActivity extends BaseActivity implements FilmListView {

    @Inject
    FilmListPresenter presenter;

    @InjectView(R.id.progressBar)
    ProgressBar progressBar;
    @InjectView(R.id.rv_films_list)
    RecyclerView rvFilmsList;

    private RecyclerView.Adapter filmsAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.film_list_activity);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected List<Object> getModules() {
        List<Object> modules = new ArrayList<>();
        modules.add(new FilmListModule(this));
        return modules;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        rvFilmsList.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        rvFilmsList.setVisibility(View.VISIBLE);
    }

    @Override
    public void setFilms(List<Film> films) {
        filmsAdapter = new FilmsAdapter(films, this);
        rvFilmsList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvFilmsList.setLayoutManager(layoutManager);
        rvFilmsList.setAdapter(filmsAdapter);
    }
}
