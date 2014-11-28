package com.jla.modelviewpresenter.filmList.presenter;

public interface FilmListPresenter {

    public void onResume();

    public void onPause();

    public void onItemClicked(int position);
}
