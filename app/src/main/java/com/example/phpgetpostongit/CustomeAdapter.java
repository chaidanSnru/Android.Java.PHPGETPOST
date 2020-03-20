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

    public CustomeAdapter(Context context, ArrayList<Movie> moviesJsonData) {
        this.context = context;
        this.moviesJsonData = moviesJsonData;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return moviesJsonData.size();
    }

    @Override
    public Object getItem(int position) {
        return moviesJsonData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return moviesJsonData.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View convertView = view;
        if (convertView==null){
            convertView = layoutInflater.inflate(R.layout.movieslist,null);
            TextView movieName = convertView.findViewById(R.id.movieName);
            TextView ratting = convertView.findViewById(R.id.ratting);
            ImageView movieImg = convertView.findViewById(R.id.movieImageView);

            movie = moviesJsonData.get(position);
            movieName.setText(movie.getName());
            ratting.setText(String.valueOf(movie.getRatting()));
            //Picasso load image
            //Picasso.with(context).load(movie.getImageUrl()).into(movieImg);
            Picasso.get().load(movie.getImageUrl()).into(movieImg);

            //set ratting
            // ratingBar.setRating((float) moviesModel.getRatting());
        }
        return convertView;
    }
}
