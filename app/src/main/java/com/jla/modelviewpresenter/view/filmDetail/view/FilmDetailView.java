package com.jla.modelviewpresenter.view.filmDetail.view;

import android.net.Uri;

public interface FilmDetailView {

    public void setPicture(Uri uri);

    public void setTitle(String title);

    public void setReleaseDate(String releaseDate);

    public void setVoteAverage(String voteAverage);

    public void setVoteCount(String voteCount);
}
