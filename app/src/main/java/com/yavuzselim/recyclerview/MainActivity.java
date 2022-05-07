package com.yavuzselim.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.yavuzselim.recyclerview.databinding.ActivityMainBinding;
import com.yavuzselim.recyclerview.databinding.ActivityTwoscreenBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Arraylisti burda tanımlayarak istediğimiz yerde kullanmayı sağlıyoruz
    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;

    //androide giderek jetpack kısmından view binding yapısını alarak view girişlerini daha verimli yapıyoruz
    //öncelikle build.gradle yapısına giderek android altına sitedeki kodu ekliyoruz
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        //andoid altına sitedeki kodu ekledikten sonra aşağıda ki 3 satırı ekliyoruz
        // inflate yapısı xml ile kodumuzu bağlamay çalıştığımız yerdir
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //Arraylist oluşturarak istenildiği kadar giriş yapılmasını sağlıyoruz
        landmarkArrayList=new ArrayList<>();



        //landmark da oluşturduğumuz sınıfın girişini yapıyoruz
        Landmark pisa=new Landmark("pisa","italy",R.drawable.pisa);
        Landmark eiffel=new Landmark("eiffel","france",R.drawable.eyfel);
        Landmark colesseum=new Landmark("colesseum","italy",R.drawable.coleseum);
        Landmark londonbrige=new Landmark("london brige","England",R.drawable.london);

        //landmar class'ı sayesinde oluşturduğumuz dataları arrayliste ekliyoruz

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colesseum);
        landmarkArrayList.add(londonbrige);


        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerview.setAdapter(landmarkAdapter);





    }
}