package com.example.phpgetpostongit;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
    Boolean status;
    int totalRecored;
    ArrayList<Movie> movies;

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

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}

