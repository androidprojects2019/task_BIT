package com.example.bit_task.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.bit_task.Api.Model.Data;
import com.example.bit_task.Api.Model.DataItem;
import com.example.bit_task.Base.BaseActivity;
import com.example.bit_task.Fragment.ImageFragment;
import com.example.bit_task.R;
import com.example.bit_task.Repositories.HomeRepository;
import com.example.bit_task.ViewModels.HomeViewModel;
import com.example.bit_task.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> {
    HomeViewModel homeViewModel = new HomeViewModel();
    Data profile = new Data();
    List<DataItem> homeItems = new ArrayList<>();
    LinearLayoutManager layoutManager;
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeRepository.context = this;
        homeViewModel = ViewModelProviders.of(this)
                .get(HomeViewModel.class);
        initRecyclerView();
        observeLiveData();
        homeViewModel.getProfile();
        homeViewModel.getHome();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected HomeViewModel getViewModel() {
        return ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    private void observeLiveData() {
        HomeViewModel.profile.observe(this, new Observer<Data>() {
            @Override
            public void onChanged(Data data) {
                profile = data;
                initProfile();

            }
        });

        HomeViewModel.homeItems.observe(this, new Observer<List<DataItem>>() {
            @Override
            public void onChanged(List<DataItem> dataItems) {
                homeItems = dataItems;
                adapter.changeData(homeItems);
                databinding.progress.setVisibility(View.INVISIBLE);
            }
        });
        HomeViewModel.messageData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer messageId) {
                showMessage(messageId, R.string.ok);
            }
        });
    }

    private void initProfile() {
        databinding.profileName.setText(profile.getFullName());
        databinding.bio.setText(profile.getBio());
        databinding.location.setText(profile.getLocation());
        Glide.with(this).load(profile.getProfilePicture()).into(databinding.profileImage);
         databinding.postsCounter.setText(profile.getCounts().getPosts()+"");
        databinding.followersCounter.setText(profile.getCounts().getFollowers()+"");
        databinding.followingCounter.setText(profile.getCounts().getFollowing()+"");

    }

    private void initRecyclerView() {
        adapter = new HomeAdapter(null);
        adapter.setOnItemClick(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, DataItem item) {
                Bundle data = new Bundle();
                data.putString("image", item.getImage());
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(item.getImage())));

                ImageFragment imageFragment = new ImageFragment();
                imageFragment.setArguments(data);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container,imageFragment)
                        .addToBackStack("")
                        .commit();
            }
        });
        layoutManager = new GridLayoutManager(this, 3);
        databinding.recycler.setAdapter(adapter);
        databinding.recycler.setLayoutManager(layoutManager);
    }
}
