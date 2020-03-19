package com.example.phpgetpostongit;

import java.util.List;

public class MovieList {
    Boolean status;
    int totalRecored;
    List<Movie> movies;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getTotalRecored() {
        return totalRecored;
    }

    public void setTotalRecored(int totalRecored) {
        this.totalRecored = totalRecored;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}

