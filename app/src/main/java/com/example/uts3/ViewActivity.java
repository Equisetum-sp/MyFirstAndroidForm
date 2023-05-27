package com.example.uts3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    User logged;
    ArrayList<Citizen> citizenData;
    public void buttonHandlerToMain(View view){
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(getString(R.string.logged), logged);
        i.putExtra(getString(R.string.citizendata), citizenData);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Intent i = getIntent();
        logged = i.getSerializableExtra(getString(R.string.logged), User.class);
        Function.isLogged(this, logged);

        citizenData = (ArrayList<Citizen>)i.getSerializableExtra(getString(R.string.citizendata), ArrayList.class);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recycle);

        ViewAdapter adapter = new ViewAdapter(citizenData);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        Button btnToMain = (Button) findViewById(R.id.button_tomain);
        btnToMain.setOnClickListener(this::buttonHandlerToMain);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}