package com.jla.modelviewpresenter.data.dataStore.film;

import com.jla.modelviewpresenter.data.model.FilmResponse;
import com.jla.modelviewpresenter.data.net.TheMovieDbAdapter;
import com.jla.modelviewpresenter.domain.repository.PreferencesRepository;

import java.util.Date;
import java.util.List;

public class CloudFilmDataStore implements FilmDataStore {

    private static final String API_KEY = "20ffea664862269a108e69164352dcd8";
    private DiskFilmDataStore diskFilmDataStore;
    private PreferencesRepository preferencesRepository;

    public CloudFilmDataStore(DiskFilmDataStore diskFilmDataStore, PreferencesRepository preferencesRepository){
        this.diskFilmDataStore = diskFilmDataStore;
        this.preferencesRepository = preferencesRepository;
    }

    @Override
    public List<FilmResponse> getPopularFilmResponse() {
        List<FilmResponse> popularFilmsResponse = new TheMovieDbAdapter().create().getPopularMovies(API_KEY, 1).getPopularFilms();
        diskFilmDataStore.savePopularFilmResponse(popularFilmsResponse);
        preferencesRepository.setLastDiskFilmUpdated(new Date());
        return popularFilmsResponse;
    }

    @Override
    public void savePopularFilmResponse(List<FilmResponse> popularFilmResponse) {
        throw new UnsupportedOperationException("Not supported method");
    }

    @Override
    public FilmResponse getFilmResponse(int id) {
        throw new UnsupportedOperationException("Not supported method");
    }
}
