package com.example.uts3;

import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    Integer id;
    String pw;

    public User(int id, String pw){
        this.id = new Integer(id);
        this.pw = pw;
    }
    public void initiate(Button btn_clear){
        btn_clear.setVisibility(View.INVISIBLE);
    }

    public ArrayList<Citizen> clearData(ArrayList<Citizen> data){
        return data;
    }
}
