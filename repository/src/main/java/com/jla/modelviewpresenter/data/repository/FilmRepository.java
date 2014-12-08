package com.jla.modelviewpresenter.data.repository;


import com.jla.modelviewpresenter.data.model.ConfigurationResponse;
import com.jla.modelviewpresenter.data.model.FilmResponse;

import java.util.List;

public interface FilmRepository {

    public ConfigurationResponse getConfiguration();

    public List<FilmResponse> getPopularFilms();
}
