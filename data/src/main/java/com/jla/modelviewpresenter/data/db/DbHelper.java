package com.jla.modelviewpresenter.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.jla.modelviewpresenter.data.model.FilmResponse;
import com.jla.modelviewpresenter.data.model.ImagesResponse;

import java.sql.SQLException;

public class DbHelper extends OrmLiteSqliteOpenHelper {

    public static final String DATABASE_NAME = "modelviewpresenter.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<FilmResponse, Integer> filmResponseDao;
    private Dao<ImagesResponse, Integer> imagesResponseDao;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, FilmResponse.class);
            TableUtils.createTable(connectionSource, ImagesResponse.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
    }

    public Dao<FilmResponse, Integer> getFilmResponseDao() throws SQLException {
        if (filmResponseDao == null) {
            filmResponseDao = getDao(FilmResponse.class);
        }
        return filmResponseDao;
    }

    public Dao<ImagesResponse, Integer> getImagesResponseDao() throws SQLException {
        if (imagesResponseDao == null) {
            imagesResponseDao = getDao(ImagesResponse.class);
        }
        return imagesResponseDao;
    }
}
