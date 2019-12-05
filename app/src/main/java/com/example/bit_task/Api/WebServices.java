package com.example.bit_task.Api;

import com.example.bit_task.Api.Model.Data;
import com.example.bit_task.Api.Model.DataItem;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface WebServices {

    @GET("home")
    Single<Data> getHome();

    @GET("profile")
    Single<DataItem> getProfile();

}
