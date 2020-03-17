package com.example.phpgetpostongit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

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
        TextView editText1 = (TextView) findViewById(R.id.editText1);
        TextView editText2 = (TextView) findViewById(R.id.editText2);
        TextView editText3 = (TextView) findViewById(R.id.editText3);
        String url = "https://chaidan2.000webhostapp.com/userInsertGet.php/?username="
                +editText1.getText()+"&password="+editText2.getText()+"&role="+editText3.getText();
        // Log.d("URL", url);
        // Instantiate new OkHttpClient
        OkHttpClient client = new OkHttpClient();
        // Initialize a new Request
        Request request = new Request.Builder()
                .url(url)
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
                        txtResult.setText(data);
                    }
                });
            }
        });
    }
}
