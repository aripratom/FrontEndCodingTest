package com.aripratom.frontendcodingtest.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {

    private static final String BASE_URL = "http://18.139.50.74:8080/";

    private static Retrofit getRetrofitInstance() {

        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static APICall getAPICall() {
        return getRetrofitInstance().create(APICall.class);
    }
}
