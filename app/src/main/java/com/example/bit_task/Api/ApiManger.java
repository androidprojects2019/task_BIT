package com.example.bit_task.Api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManger {
    private static Retrofit retrofit;

    private static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://i0sa.com/bit/task/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        }
        return retrofit;
    }

    public static WebServices getApis() {
        return getInstance().create(WebServices.class);
    }
}
