package com.jla.modelviewpresenter.data.entity;

import com.jla.modelviewpresenter.domain.model.Film;

import java.util.List;

public class FilmResponse {

    private int page;
    private List<Film> results;

    public FilmResponse(int page, List<Film> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Film> getResults() {
        return results;
    }

    public void setResults(List<Film> results) {
        this.results = results;
    }
}
