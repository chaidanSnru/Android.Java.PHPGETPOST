package com.example.phpgetpostongit;

import java.util.ArrayList;
import java.util.List;

public class MovieList {
    Boolean status;
    int total_recoreds;
    ArrayList<Movie> movies;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getTotalRecored() {
        return total_recoreds;
    }

    public void setTotalRecored(int total_recoreds) {
        this.total_recoreds = total_recoreds;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}

