package com.example.uts3;

import java.io.Serializable;

public class Citizen implements Serializable {
    public String NIK, fullname, address, village, district, city, province, postalCode, DoB, occupation, religion;
    public boolean sex, married;
    public int rt, rw;


    public Citizen(){
        NIK = new String();
        fullname = new String();
        address = new String();
        village = new String();
        district = new String();
        city = new String();
        province = new String();
        postalCode = new String();
        occupation = new String();
        religion = new String();
        DoB = new String();
    }

    public String getSex(){
        return this.sex ? "Laki-laki" : "Perempuan";
    }
    public String getMarried(){
        return this.married ? "Sudah menikah" : "Belum menikah";
    }
}
