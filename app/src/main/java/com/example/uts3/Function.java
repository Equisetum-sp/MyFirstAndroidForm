package com.example.uts3;

import android.app.Activity;
import android.content.Intent;

public class Function {
    public static void isLogged(Activity a, User logged) {
        if(logged != null){
            return;
        }

        Intent login = new Intent(a, LoginActivity.class);
        a.startActivity(login);
        a.finish();
    }
}
