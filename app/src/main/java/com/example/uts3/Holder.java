package com.example.uts3;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder{
    public TextView NIK, fullname, sex, address, DoB, occupation, married, religion;

    public Holder(View itemView){
        super(itemView);
        NIK = (TextView) itemView.findViewById(R.id.view_NIK);
        fullname = (TextView) itemView.findViewById(R.id.view_fullname);
        sex = (TextView) itemView.findViewById(R.id.view_sex);
        address = (TextView) itemView.findViewById(R.id.view_address);
        DoB = (TextView) itemView.findViewById(R.id.view_DoB);
        occupation = (TextView) itemView.findViewById(R.id.view_occupation);
        married = (TextView) itemView.findViewById(R.id.view_married);
        religion = (TextView) itemView.findViewById(R.id.view_religion);

    }
}