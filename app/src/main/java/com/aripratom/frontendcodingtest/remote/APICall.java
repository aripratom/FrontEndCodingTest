package com.aripratom.frontendcodingtest.remote;

import com.aripratom.frontendcodingtest.model.Token;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APICall {
    @FormUrlEncoded
    @POST("http://18.139.50.74:8080/register")
    Call<Token> register(@Field("email") String email, @Field("username") String username, @Field("password") String password);

    @POST("http://18.139.50.74:8080/login")
    Call<Token> login(@Field("username") String username, @Field("password") String password);

    //@GET("/phptest/jwttest.php")
    //Call<String> getUser(@Header("Authorization") String authorization);
}
