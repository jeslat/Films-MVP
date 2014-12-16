package com.jla.modelviewpresenter.data.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.jla.modelviewpresenter.domain.repository.PreferencesRepository;

import java.util.Date;

public class PreferencesRepositoryImpl implements PreferencesRepository {

    private static final String LAST_DISK_FILM_UPDATED = "last_disk_film_updated";
    private static final String LAST_DISK_IMAGES_UPDATED = "last_disk_images_updated";

    private SharedPreferences sharedPreferences;

    public PreferencesRepositoryImpl(Context context){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public Date getLastDiskFilmUpdated() {
        long milis = sharedPreferences.getLong(LAST_DISK_FILM_UPDATED, 0);
        return new Date(milis);
    }

    @Override
    public void setLastDiskFilmUpdated(Date date) {
        sharedPreferences.edit().putLong(LAST_DISK_FILM_UPDATED, date.getTime()).apply();
    }

    @Override
    public Date getLastDiskImagesUpdated() {
        long milis = sharedPreferences.getLong(LAST_DISK_IMAGES_UPDATED, 0);
        return new Date(milis);
    }

    @Override
    public void setLastDiskImagesUpdated(Date date) {
        sharedPreferences.edit().putLong(LAST_DISK_IMAGES_UPDATED, date.getTime()).apply();
    }
}
