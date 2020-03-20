package com.example.phpgetpostongit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
