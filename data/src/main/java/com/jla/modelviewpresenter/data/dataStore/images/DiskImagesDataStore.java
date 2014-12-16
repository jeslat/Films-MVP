package com.jla.modelviewpresenter.data.dataStore.images;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.jla.modelviewpresenter.data.db.DbHelper;
import com.jla.modelviewpresenter.data.model.ImagesResponse;

import java.sql.SQLException;

public class DiskImagesDataStore implements ImagesDataStore {

    private static final String TAG = DiskImagesDataStore.class.getCanonicalName();
    private Context context;

    public DiskImagesDataStore(Context context) {
        this.context = context;
    }

    @Override
    public ImagesResponse getImagesResponse() {
        DbHelper dbHelper = OpenHelperManager.getHelper(context, DbHelper.class);
        Dao imagesResponseDao;
        ImagesResponse imagesResponse = null;
        try {
            imagesResponseDao = dbHelper.getImagesResponseDao();
            imagesResponse = (ImagesResponse) imagesResponseDao.queryForAll().get(0);
        } catch (SQLException e) {
            Log.e(TAG, e.getMessage());
        } finally {
            OpenHelperManager.releaseHelper();
        }

        return imagesResponse;
    }

    @Override
    public void saveImagesResponse(ImagesResponse imagesResponse) {
        DbHelper dbHelper = OpenHelperManager.getHelper(context, DbHelper.class);
        Dao imagesResponseDao;
        try {
            imagesResponseDao = dbHelper.getImagesResponseDao();
            imagesResponseDao.create(imagesResponse);
        } catch (SQLException e) {
            Log.e(TAG, e.getMessage());
        } finally {
            OpenHelperManager.releaseHelper();
        }
    }
}
