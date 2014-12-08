package com.jla.modelviewpresenter.data.model;

import java.util.List;

public class PopularFilmsResponse {

    private int page;
    private List<FilmResponse> results;

    public PopularFilmsResponse(int page, List<FilmResponse> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<FilmResponse> getPopularFilms() {
        return results;
    }

    public void setPopularFilms(List<FilmResponse> popularFilms) {
        this.results = popularFilms;
    }
}
