package com.example.bit_task.ViewModels;

import com.example.bit_task.Api.Model.Data;
import com.example.bit_task.Api.Model.DataItem;
import com.example.bit_task.Repositories.HomeRepository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class HomeViewModel extends ViewModel {
    public static MutableLiveData<Data> profile = new MutableLiveData<>();
    public static MutableLiveData<Integer> messageData = new MutableLiveData<>();
    public static MutableLiveData<List<DataItem>> homeItems = new MutableLiveData<>();

    HomeRepository homeRepository = new HomeRepository();

    public HomeViewModel() {

        profile = homeRepository.profile;
        messageData = homeRepository.messageData;
        homeItems = homeRepository.homeItems;
    }

    public void getProfile() {

        homeRepository.getProfile();
    }
    public void getHome() {

        homeRepository.getHome();
    }


}
