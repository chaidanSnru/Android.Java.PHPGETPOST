package com.example.phpgetpostongit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
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
        // Instantiate new OkHttpClient
        OkHttpClient client = new OkHttpClient();

        // Initialize a new Request
        Request request = new Request.Builder()
                //.url("https://chaidan2.000webhostapp.com/first.php")
                .url("https://tutorialscache.com/movies.json")
                //.url("https://api.androidhive.info/contacts/")
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
                        // Display requested url data as string into text view
                        // txtResult.setText(data);
                        // Display requested url data in Toast
                        // Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();
                        Gson gson = new Gson();
                        MovieList movieList = gson.fromJson(data, MovieList.class);
                        StringBuilder builder = new StringBuilder();
                        builder.setLength(0);
                        List<Movie> movies = movieList.getMovies();
                        for(Movie movie : movies){
                            builder.append(movie.getName());
                            builder.append("\n");
                        }
                        Toast.makeText(getApplicationContext(),builder.toString(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
