package com.jla.modelviewpresenter.data.dataStore.film;

import android.content.Context;

import com.jla.modelviewpresenter.domain.repository.PreferencesRepository;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FilmDataStoreFactory {

    private static final long MAXIMUM_MILLISECONDS = TimeUnit.HOURS.toMillis(1);

    private PreferencesRepository preferencesRepository;
    private Context context;

    public FilmDataStoreFactory(PreferencesRepository preferencesRepository, Context context){
        this.preferencesRepository = preferencesRepository;
        this.context = context;
    }

    public FilmDataStore create() {
        DiskFilmDataStore diskFilmDataStore = new DiskFilmDataStore(context);
        Date lastDiskFilmUpdated = preferencesRepository.getLastDiskFilmUpdated();
        if (new Date().getTime() - lastDiskFilmUpdated.getTime() > MAXIMUM_MILLISECONDS)
            return new CloudFilmDataStore(diskFilmDataStore, preferencesRepository);
        else
            return diskFilmDataStore;
    }
}
