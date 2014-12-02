package com.jla.modelviewpresenter.data.entity;

public class Film {

    private boolean adult;
    private String backdrop_path;
    private int id;
    private String original_title;
    private String release_date;
    private String poster_path;
    private double popularity;
    private String title;
    private double vote_average;
    private int vote_count;

    public Film(boolean adult, String backdropPath, int id, String originalTitle, String releaseDate, String posterPath, double popularity, String title, double voteAverage, int voteCount) {
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
