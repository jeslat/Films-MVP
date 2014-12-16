package com.jla.modelviewpresenter.data.repository;

import com.jla.modelviewpresenter.data.dataStore.film.FilmDataStore;
import com.jla.modelviewpresenter.data.dataStore.film.FilmDataStoreFactory;
import com.jla.modelviewpresenter.data.dataStore.images.ImagesDataStore;
import com.jla.modelviewpresenter.data.dataStore.images.ImagesDataStoreFactory;
import com.jla.modelviewpresenter.data.model.FilmResponse;
import com.jla.modelviewpresenter.data.model.ImagesResponse;
import com.jla.modelviewpresenter.data.model.mapper.FilmResponseDataMapper;
import com.jla.modelviewpresenter.domain.model.Film;
import com.jla.modelviewpresenter.domain.repository.FilmRepository;

import java.util.List;

public class FilmRepositoryImpl implements FilmRepository {

    private final ImagesDataStoreFactory imagesDataStoreFactory;
    private final FilmDataStoreFactory filmDataStoreFactory;

    public FilmRepositoryImpl(ImagesDataStoreFactory imagesDataStoreFactory, FilmDataStoreFactory filmDataStoreFactory) {
        this.imagesDataStoreFactory = imagesDataStoreFactory;
        this.filmDataStoreFactory = filmDataStoreFactory;
    }

    @Override
    public List<Film> getPopularFilms() {
        FilmDataStore filmDataStore = filmDataStoreFactory.create();
        ImagesDataStore imagesDataStore = imagesDataStoreFactory.create();
        ImagesResponse imagesResponse = imagesDataStore.getImagesResponse();
        List<FilmResponse> filmResponses = filmDataStore.getPopularFilmResponse();
        return FilmResponseDataMapper.transform(filmResponses, imagesResponse);
    }
}
