package com.jla.modelviewpresenter.data.dataStore.images;

import android.content.Context;

import com.jla.modelviewpresenter.domain.repository.PreferencesRepository;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ImagesDataStoreFactory {

    private static final long MAXIMUM_MILLISECONDS = TimeUnit.DAYS.toMillis(1);

    private PreferencesRepository preferencesRepository;
    private Context context;

    public ImagesDataStoreFactory(PreferencesRepository preferencesRepository, Context context){
        this.preferencesRepository = preferencesRepository;
        this.context = context;
    }

    public ImagesDataStore create() {
        DiskImagesDataStore diskConfigurationDataStore = new DiskImagesDataStore(context);
        Date lastDiskConfigurationUpdated = preferencesRepository.getLastDiskImagesUpdated();
        if (new Date().getTime() - lastDiskConfigurationUpdated.getTime() > MAXIMUM_MILLISECONDS)
            return new CloudImagesDataStore(diskConfigurationDataStore, preferencesRepository);
        else
            return diskConfigurationDataStore;
    }
}
