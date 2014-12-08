package com.jla.modelviewpresenter.data.model;

public class ConfigurationResponse {

    private ImagesResponse images;

    public ConfigurationResponse(ImagesResponse images) {
        this.images = images;
    }

    public ImagesResponse getImages() {
        return images;
    }

    public void setImages(ImagesResponse images) {
        this.images = images;
    }
}
