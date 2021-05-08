package com.example.regapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService
{
    @FormUrlEncoded
    @POST("register.php")
    Call<Result> registerUser(@Field("name") String name,
                              @Field("email") String email,
                              @Field("password") String password);
}
