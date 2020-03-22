package com.example.phpgetpostongit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomeAdapter extends BaseAdapter {
    Context context;
    Movie movie;
    ArrayList<Movie> moviesJsonData;
    LayoutInflater layoutInflater;

    // Constructure method with 2 argument context and arraylist
    public CustomeAdapter(Context context, ArrayList<Movie> moviesJsonData) {
        this.context = context;
        this.moviesJsonData = moviesJsonData;
        // Declare lyoutinflater for custom layout with this context in listview
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // count number for json data
    @Override
    public int getCount() {
        return moviesJsonData.size();
    }

    //get Oject from json data
    @Override
    public Object getItem(int position) {
        return moviesJsonData.get(position);
    }

    //get ID from json
    @Override
    public long getItemId(int position) {
        return moviesJsonData.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View convertView = view;
        if (convertView==null){
            // set movielist layout to listview
            convertView = layoutInflater.inflate(R.layout.movieslist,null);
            // set R.id.xxx for views in movielist layout
            TextView movieName = convertView.findViewById(R.id.movieName);
            TextView ratting = convertView.findViewById(R.id.ratting);
            ImageView movieImg = convertView.findViewById(R.id.movieImageView);
            // Get movie objec from movie arraylist
            movie = moviesJsonData.get(position);
            // Set text to Textview
            movieName.setText(movie.getName());
            ratting.setText(String.valueOf(movie.getRatting()));
            // Picasso load image
            Picasso.get().load(movie.getImage()).resize(375,102).into(movieImg);
        }
        return convertView;
    }
}
