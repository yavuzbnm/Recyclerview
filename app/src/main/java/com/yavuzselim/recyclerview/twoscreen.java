package com.yavuzselim.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yavuzselim.recyclerview.databinding.ActivityTwoscreenBinding;

public class twoscreen extends AppCompatActivity {
    private ActivityTwoscreenBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTwoscreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent=getIntent();

        Landmark selectedLandmark= (Landmark) intent.getSerializableExtra("landmark");

        binding.nametext.setText(selectedLandmark.name);
        binding.countrytext.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);







    }
}




