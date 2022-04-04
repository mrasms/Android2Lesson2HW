package com.example.hwandroid2lesson2.fragments.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hwandroid2lesson2.databinding.HolderBinding;
import com.example.hwandroid2lesson2.fragments.model.Model;

import java.util.ArrayList;

public class AdapterOnBoard extends RecyclerView.Adapter<AdapterOnBoard.Holder> {
    private ArrayList<Model> list = new ArrayList<>();

    public AdapterOnBoard(ArrayList<Model> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(HolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private HolderBinding binding;

        public Holder(HolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Model model) {
            binding.tvDescription.setText(model.getDescription());
            binding.imForPager.setImageResource(model.getImage());
        }
    }
}
