package com.example.bit_task.Repositories;


import android.content.Context;

import com.example.bit_task.Api.ApiManger;
import com.example.bit_task.Api.Model.Data;
import com.example.bit_task.Api.Model.DataItem;
import com.example.bit_task.Api.Model.HomeResponse;
import com.example.bit_task.Api.Model.ProfileResponse;
import com.example.bit_task.R;


import java.util.List;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeRepository {
    public MutableLiveData<Data> profile = new MutableLiveData<>();
    public MutableLiveData<Integer> messageData = new MutableLiveData<>();
    public static MutableLiveData<List<DataItem>> homeItems = new MutableLiveData<>();
    public static Context context;

    public void getProfile() {
        ApiManger.getApis().getProfile().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<ProfileResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ProfileResponse profileResponse) {
                        profile.setValue(profileResponse.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        messageData.setValue(R.string.somthing_went_wrong);

                    }
                });
    }

    public void getHome() {
        ApiManger.getApis().getHome().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<HomeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(HomeResponse homeResponse) {
                        homeItems.setValue(homeResponse.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        messageData.setValue(R.string.somthing_went_wrong);

                    }
                });
    }
}
