package com.jla.modelviewpresenter.data.dataStore.film;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.jla.modelviewpresenter.data.db.DbHelper;
import com.jla.modelviewpresenter.data.model.FilmResponse;

import java.sql.SQLException;
import java.util.List;

public class DiskFilmDataStore implements FilmDataStore {

    private static final String TAG = DiskFilmDataStore.class.getCanonicalName();
    private Context context;

    public DiskFilmDataStore(Context context) {
        this.context = context;
    }

    @Override
    public List<FilmResponse> getPopularFilmResponse() {
        DbHelper dbHelper = OpenHelperManager.getHelper(context, DbHelper.class);
        Dao filmResponseDao;
        List<FilmResponse> filmResponses = null;
        try {
            filmResponseDao = dbHelper.getFilmResponseDao();
            filmResponses = filmResponseDao.queryForAll();
        } catch (SQLException e) {
            Log.e(TAG, e.getMessage());
        } finally {
            OpenHelperManager.releaseHelper();
        }

        return filmResponses;
    }

    @Override
    public void savePopularFilmResponse(List<FilmResponse> popularFilmResponses) {
        DbHelper dbHelper = OpenHelperManager.getHelper(context, DbHelper.class);
        Dao filmResponseDao;
        try {
            filmResponseDao = dbHelper.getFilmResponseDao();
            for (FilmResponse filmResponse : popularFilmResponses) {
                filmResponseDao.create(filmResponse);
            }
        } catch (SQLException e) {
            Log.e(TAG, e.getMessage());
        } finally {
            OpenHelperManager.releaseHelper();
        }
    }
}
