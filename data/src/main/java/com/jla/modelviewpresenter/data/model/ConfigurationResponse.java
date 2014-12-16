package com.jla.modelviewpresenter.data.model;

import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ConfigurationResponse {

    private int id;
    private ImagesResponse images;

    public ConfigurationResponse() {
    }

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
