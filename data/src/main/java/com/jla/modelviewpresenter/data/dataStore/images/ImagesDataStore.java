package com.jla.modelviewpresenter.data.dataStore.images;

import com.jla.modelviewpresenter.data.model.ImagesResponse;

public interface ImagesDataStore {

    public ImagesResponse getImagesResponse();

    public void saveImagesResponse(ImagesResponse imagesResponse);
}
