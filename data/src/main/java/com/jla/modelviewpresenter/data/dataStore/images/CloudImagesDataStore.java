package com.jla.modelviewpresenter.data.dataStore.images;

import com.jla.modelviewpresenter.data.model.ConfigurationResponse;
import com.jla.modelviewpresenter.data.model.ImagesResponse;
import com.jla.modelviewpresenter.data.net.TheMovieDbAdapter;
import com.jla.modelviewpresenter.domain.repository.PreferencesRepository;

import java.util.Date;

public class CloudImagesDataStore implements ImagesDataStore {

    private static final String API_KEY = "20ffea664862269a108e69164352dcd8";
    private final DiskImagesDataStore diskImagesDataStore;
    private final PreferencesRepository preferencesRepository;

    public CloudImagesDataStore(DiskImagesDataStore diskImagesDataStore, PreferencesRepository preferencesRepository){
        this.diskImagesDataStore = diskImagesDataStore;
        this.preferencesRepository = preferencesRepository;
    }

    @Override
    public ImagesResponse getImagesResponse() {
        ConfigurationResponse configurationResponse = new TheMovieDbAdapter().create().getConfiguration(API_KEY);
        diskImagesDataStore.saveImagesResponse(configurationResponse.getImages());
        preferencesRepository.setLastDiskImagesUpdated(new Date());
        return configurationResponse.getImages();
    }

    @Override
    public void saveImagesResponse(ImagesResponse imagesResponse) {
        throw new UnsupportedOperationException("Not supported method");
    }
}
