package com.example.phpgetpostongit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) throws IOException {
        final TextView textView = (TextView)findViewById(R.id.textView);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://chaidan2.000webhostapp.com/first.php")
                .build();
        Response response = client.newCall(request).execute();
        final String res = response.body().string();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(res);
            }
        });
    }
}
