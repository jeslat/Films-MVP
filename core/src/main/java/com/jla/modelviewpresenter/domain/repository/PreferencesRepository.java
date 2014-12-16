package com.jla.modelviewpresenter.domain.repository;

import java.util.Date;

public interface PreferencesRepository {

    public Date getLastDiskFilmUpdated();

    public void setLastDiskFilmUpdated(Date date);

    public Date getLastDiskImagesUpdated();

    public void setLastDiskImagesUpdated(Date date);
}
