package com.example.uts3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    //region View Declaration
    EditText loginIdEditText, nameEditText;
    TextView wrongpw;
    //endregion

    User[] users = new User[2];
    int loginid;
    String loginpw;
    ArrayList<Citizen> citizenData = null;

    //region Login method
    public User check(){
        for(int i=0; i< users.length; i++) {
            if (loginid == users[i].id && loginpw.equals(users[i].pw)){
                return users[i];
            }
        }
        return null;
    }

    public void login(View view){
        try{
            this.loginid = Integer.parseInt(loginIdEditText.getText().toString());
        }catch (Exception e){
            this.loginid = 0;
            Log.e("IdOnLoginActivity", "NumberFormatException");
        }
        this.loginpw = nameEditText.getText().toString();

        User logged = check();

        if(logged == null) {
            wrongpw.setVisibility(View.VISIBLE);
            return;
        }

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(getString(R.string.logged), logged);
        i.putExtra(getString(R.string.citizendata), citizenData);
        startActivity(i);
        finish();
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginIdEditText = (EditText) findViewById(R.id.login_id);
        nameEditText = (EditText) findViewById(R.id.login_pw);

        wrongpw = (TextView) findViewById(R.id.wrongpw);
        wrongpw.setVisibility(View.INVISIBLE);

        users[0] = new User(1, "user");
        users[1] = new Admin(2, "admin");


        Button btnLogin = (Button) findViewById(R.id.button_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(v);
            }
        });
    }

    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        ArrayList<Citizen> buffer = (ArrayList<Citizen>)i.getSerializableExtra(getString(R.string.citizendata), ArrayList.class);
        if(buffer != null){
            citizenData = buffer;
        }
    }
}