package com.example.phpgetpostongit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        final TextView txtResult = (TextView) findViewById(R.id.textView);
        final ListView listView = (ListView)findViewById(R.id.listView);
        final Context context = this;
        // Instantiate new OkHttpClient
        OkHttpClient client = new OkHttpClient();
        // Initialize a new Request
        Request request = new Request.Builder()
                .url("https://tutorialscache.com/movies.json")
                //.url("https://api.androidhive.info/contacts/")
                //.url("https://chaidan2.000webhostapp.com/movies.json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // Do something when request failed
                e.printStackTrace();
                Log.d("OKhttp", "Request Failed.");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Error : " + response);
                } else {
                    Log.d("OKhttp", "Request Successful.");
                }

                // Read data in the worker thread
                final String data = response.body().string();

                // Display the requested data on UI in main thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Created GSON obj
                        Gson gson = new Gson();
                        // Transform movie json data to MovieList model class
                        MovieList movieList = gson.fromJson(data, MovieList.class);
                        // Created Movie arraylist from Movielist
                        ArrayList<Movie> movies = movieList.getMovies();
                        // Created movie arraylist adapter for listview
                        CustomeAdapter customeAdapter = new CustomeAdapter(context,movies);
                        // set adapter with created adapter
                        listView.setAdapter(customeAdapter);
                    }
                });
            }
        });
    }
}
