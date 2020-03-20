package com.example.phpgetpostongit;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MovieAdapter extends ArrayAdapter<Movie> {
    public MovieAdapter(ArrayAdapter<Movie> data, Context context){
        super(context, R.layout.movieslist);

    }
}
