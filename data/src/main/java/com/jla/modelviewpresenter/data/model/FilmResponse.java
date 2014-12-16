package com.jla.modelviewpresenter.data.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class FilmResponse {

    private static final String ADULT = "adult";
    private static final String BACKDROP_PATH = "backdropPath";
    private static final String ID = "id";
    private static final String ORIGINAL_TITLE = "originalTitle";
    private static final String RELEASE_DATE = "releaseDate";
    private static final String POSTER_PATH = "posterPath";
    private static final String POPULARITY = "popularity";
    private static final String TITLE = "title";
    private static final String VOTE_AVERAGE = "voteAverage";
    private static final String VOTE_COUNT = "voteCount";

    @DatabaseField(columnName = ADULT)
    private boolean adult;
    @DatabaseField(columnName = BACKDROP_PATH)
    private String backdrop_path;
    @DatabaseField(columnName = ID)
    private int id;
    @DatabaseField(columnName = ORIGINAL_TITLE)
    private String original_title;
    @DatabaseField(columnName = RELEASE_DATE)
    private String release_date;
    @DatabaseField(columnName = POSTER_PATH)
    private String poster_path;
    @DatabaseField(columnName = POPULARITY)
    private double popularity;
    @DatabaseField(columnName = TITLE)
    private String title;
    @DatabaseField(columnName = VOTE_AVERAGE)
    private double vote_average;
    @DatabaseField(columnName = VOTE_COUNT)
    private int vote_count;

    public FilmResponse() {
    }

    public FilmResponse(boolean adult, String backdropPath, int id, String originalTitle, String releaseDate, String posterPath, double popularity, String title, double voteAverage, int voteCount) {
        this.adult = adult;
        this.backdrop_path = backdropPath;
        this.id = id;
        this.original_title = originalTitle;
        this.release_date = releaseDate;
        this.poster_path = posterPath;
        this.popularity = popularity;
        this.title = title;
        this.vote_average = voteAverage;
        this.vote_count = voteCount;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdrop_path;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdrop_path = backdropPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public void setOriginalTitle(String originalTitle) {
        this.original_title = originalTitle;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(String releaseDate) {
        this.release_date = releaseDate;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVoteAverage() {
        return vote_average;
    }

    public void setVoteAverage(double voteAverage) {
        this.vote_average = voteAverage;
    }

    public int getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(int voteCount) {
        this.vote_count = voteCount;
    }
}
