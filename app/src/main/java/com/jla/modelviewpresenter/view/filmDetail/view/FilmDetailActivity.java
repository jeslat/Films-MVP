package com.jla.modelviewpresenter.view.filmDetail.view;

import android.os.Bundle;

import com.jla.modelviewpresenter.R;
import com.jla.modelviewpresenter.view.filmDetail.module.FilmDetailModule;
import com.jla.modelviewpresenter.view.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class FilmDetailActivity extends BaseActivity implements FilmDetailView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.film_detail_activity);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected List<Object> getModules() {
        List<Object> modules = new ArrayList<>();
        modules.add(new FilmDetailModule(this));
        return modules;
    }
}
