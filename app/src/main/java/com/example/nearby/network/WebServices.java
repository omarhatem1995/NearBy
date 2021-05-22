package com.example.nearby.network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class WebServices {

    public static final String BASE_URL = "https://api.foursquare.com/";

    public static Apis getApis() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        OkHttpClient.Builder client = new OkHttpClient.Builder();


        client.connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);


        Retrofit retrofit = new Retrofit.Builder()
                .client(client.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(Apis.class);


    }

}
