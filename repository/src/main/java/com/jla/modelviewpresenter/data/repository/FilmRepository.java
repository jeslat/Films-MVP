package com.jla.modelviewpresenter.data.repository;


import com.jla.modelviewpresenter.data.entity.Film;

import java.util.List;

public interface FilmRepository {

    public List<Film> getPopularFilms();
}
