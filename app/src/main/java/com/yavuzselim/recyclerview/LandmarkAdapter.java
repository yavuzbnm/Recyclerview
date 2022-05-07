package com.yavuzselim.recyclerview;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.yavuzselim.recyclerview.databinding.RecyclerRowBinding;


import java.util.ArrayList;
//extends ederek recyclerView içindeki tüm metodları kullanmamızı sağlıyor
//recyclerView kullanmak için yazılması gereken sınıftır bu sınıf sayesinde listeye istediğimiz kadar giriş  yapabiliriz

// görünümlerimiz tutan yardımcı bir sınıftır
public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {

    ArrayList<Landmark> landmaklist;

    public LandmarkAdapter(ArrayList<Landmark> landmaklist) {
        this.landmaklist = landmaklist;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(LandmarkAdapter.LandmarkHolder holder, int position) {
        holder.binding.recyclerviewTextView.setText(landmaklist.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),twoscreen.class);

                intent.putExtra("landmark",landmaklist.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return landmaklist.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;

        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}