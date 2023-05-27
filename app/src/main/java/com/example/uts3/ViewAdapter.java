package com.example.uts3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<Holder>{
    ArrayList<Citizen> itemList;

    public ViewAdapter(ArrayList<Citizen> list){
        itemList = list;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.list_view, parent, false);

        return new Holder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position){
        Citizen curr = itemList.get(position);
        holder.NIK.setText(curr.NIK);
        holder.fullname.setText(curr.fullname);
        holder.sex.setText(curr.getSex());
        String fulladdress = curr.address + ", RT " + curr.rt + " RW " + curr.rw + ", " + curr.village + ", " + curr.district + ", " + curr.city + ", " + curr.province + " " + curr.postalCode;
        holder.address.setText(fulladdress);
        holder.DoB.setText(curr.DoB);
        holder.occupation.setText(curr.occupation);
        holder.married.setText(curr.getMarried());
        holder.religion.setText(curr.religion);
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }
}
