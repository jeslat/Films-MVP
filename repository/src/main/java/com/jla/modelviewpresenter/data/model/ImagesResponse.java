package com.jla.modelviewpresenter.data.model;

public class ImagesResponse {

    private String base_url;
    private String secure_base_url;
    private String[] backdrop_sizes;
    private String[] logo_sizes;
    private String[] poster_sizes;
    private String[] profile_sizes;
    private String[] still_sizes;

    public ImagesResponse(String base_url, String secure_base_url, String[] backdrop_sizes, String[] logo_sizes, String[] poster_sizes, String[] profile_sizes, String[] still_sizes) {
        this.base_url = base_url;
        this.secure_base_url = secure_base_url;
        this.backdrop_sizes = backdrop_sizes;
        this.logo_sizes = logo_sizes;
        this.poster_sizes = poster_sizes;
        this.profile_sizes = profile_sizes;
        this.still_sizes = still_sizes;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getSecure_base_url() {
        return secure_base_url;
    }

    public void setSecure_base_url(String secure_base_url) {
        this.secure_base_url = secure_base_url;
    }

    public String[] getBackdrop_sizes() {
        return backdrop_sizes;
    }

    public void setBackdrop_sizes(String[] backdrop_sizes) {
        this.backdrop_sizes = backdrop_sizes;
    }

    public String[] getLogo_sizes() {
        return logo_sizes;
    }

    public void setLogo_sizes(String[] logo_sizes) {
        this.logo_sizes = logo_sizes;
    }

    public String[] getPoster_sizes() {
        return poster_sizes;
    }

    public void setPoster_sizes(String[] poster_sizes) {
        this.poster_sizes = poster_sizes;
    }

    public String[] getProfile_sizes() {
        return profile_sizes;
    }

    public void setProfile_sizes(String[] profile_sizes) {
        this.profile_sizes = profile_sizes;
    }

    public String[] getStill_sizes() {
        return still_sizes;
    }

    public void setStill_sizes(String[] still_sizes) {
        this.still_sizes = still_sizes;
    }
}
