package com.example.phpgetpostongit;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class asyncGet {
    private OkHttpClient asyncGetClient = new OkHttpClient();
    String asyncRequest(String url) throws IOException {
        Request request = new Request.Builder()
            .url(url)
            .build();
        Call call = asyncGetClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace(); // not finished yet
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (Response response1 = response.body()){} //not finished yet
            }
        });
    }
}
