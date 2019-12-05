package com.example.bit_task.Api;

import com.example.bit_task.Api.Model.Data;
import com.example.bit_task.Api.Model.DataItem;
import com.example.bit_task.Api.Model.HomeResponse;
import com.example.bit_task.Api.Model.ProfileResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface WebServices {

    @GET("home")
    Single<HomeResponse> getHome();

    @GET("profile")
    Single<ProfileResponse> getProfile();

}
