package com.example.uts3;

import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends User implements Serializable {

    public Admin(int id, String pw){
        super(id, pw);
    }

    @Override
    public void initiate(Button btn_clear){
        btn_clear.setVisibility(View.VISIBLE);
    }

    @Override
    public ArrayList<Citizen> clearData(ArrayList<Citizen> data){
        data.clear();
        return data;
    }
}
