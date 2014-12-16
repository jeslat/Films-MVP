package com.jla.modelviewpresenter.data.dataStore.film;

import com.jla.modelviewpresenter.data.model.FilmResponse;

import java.util.List;

public interface FilmDataStore {

    public List<FilmResponse> getPopularFilmResponse();

    public void savePopularFilmResponse(List<FilmResponse> popularFilmResponse);
}
