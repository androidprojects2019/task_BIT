package com.example.bit_task.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bit_task.R;

public class ImageFragment extends Fragment {

    ImageView imageView;

    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String image = getArguments().getString("image");
        imageView.setImageURI(Uri.parse(image));
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

}
