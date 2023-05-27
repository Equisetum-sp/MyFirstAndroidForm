package com.example.uts3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //region View Declaration
    EditText NIKEditText;
    EditText nameEditText;
    EditText addressEditText;
    EditText rtEditText;
    EditText rwEditText;
    EditText postEditText;
    EditText villageEditText;
    EditText districtEditText;
    EditText cityEditText;
    EditText provinceEditText;
    EditText DoBdateEditText;
    EditText DoBmonthEditText;
    EditText DoByearEditText;
    EditText occupationEditText;
    RadioGroup religionr1;
    RadioGroup religionr2;
    RadioGroup religionr3;
    //endregion

    User logged;

    ArrayList<Citizen> citizenData = new ArrayList<>();
    Citizen newCitizen = new Citizen();




    //region radio button handler
    public void radioButtonHandlerSex(View view){
        boolean checked = ((RadioButton) view).isChecked();

        if(checked) {
            if (view.getId() == R.id.male) {
                newCitizen.sex = true;
            }
            else if (view.getId() == R.id.female) {
                newCitizen.sex = false;
            }
        }
    }

    public void radioButtonHandlerReligion(View view){
        boolean checked = ((RadioButton) view).isChecked();

        if(checked){
            if(view.getId() == R.id.islam) {
                religionr2.clearCheck();
                religionr3.clearCheck();
                newCitizen.religion = getString(R.string.islam);
            }
            else if(view.getId() == R.id.catholic) {
                religionr2.clearCheck();
                religionr3.clearCheck();
                newCitizen.religion = getString(R.string.catholic);
            }
            else if(view.getId() == R.id.protestant) {
                religionr2.clearCheck();
                religionr3.clearCheck();
                newCitizen.religion = getString(R.string.protestant);
            }
            else if(view.getId() == R.id.buddha) {
                religionr1.clearCheck();
                religionr3.clearCheck();
                newCitizen.religion = getString(R.string.buddha);
            }
            else if(view.getId() == R.id.hindu) {
                religionr1.clearCheck();
                religionr3.clearCheck();
                newCitizen.religion = getString(R.string.hindu);
            }
            else if(view.getId() == R.id.confucianism) {
                religionr1.clearCheck();
                religionr3.clearCheck();
                newCitizen.religion = getString(R.string.confucianism);
            }
            else if(view.getId() == R.id.otherreligion) {
                religionr1.clearCheck();
                religionr2.clearCheck();
                newCitizen.religion = getString(R.string.otherreligion);
            }
        }

    }


    public void radioButtonHandlerMarriage(View view){
        boolean checked = ((RadioButton) view).isChecked();

        if(checked) {
            if (view.getId() == R.id.married) {
                newCitizen.married = true;
            }
            else if (view.getId() == R.id.notmarried) {
                newCitizen.married = false;
            }
        }
    }
    //endregion

    //region button handler
    public void buttonHandlerSubmit(View view){
        newCitizen.NIK = NIKEditText.getText().toString();

        newCitizen.fullname = nameEditText.getText().toString();

        newCitizen.address = addressEditText.getText().toString();

        try{
            newCitizen.rt = Integer.parseInt(rtEditText.getText().toString());
        }catch (Exception e){
            newCitizen.rt = 0;
            Log.e("RtOnMainActivity", "NumberFormatException");
        }

        try {
            newCitizen.rw = Integer.parseInt(rwEditText.getText().toString());
        }catch (Exception e){
            newCitizen.rw = 0;
            Log.e("RwOnMainActivity", "NumberFormatException");
        }

        newCitizen.postalCode = postEditText.getText().toString();

        newCitizen.village = villageEditText.getText().toString();

        newCitizen.district = districtEditText.getText().toString();

        newCitizen.city = cityEditText.getText().toString();

        newCitizen.province = provinceEditText.getText().toString();

        newCitizen.DoB = (DoBdateEditText.getText().toString() + "/" + DoBmonthEditText.getText().toString() + "/" +DoByearEditText.getText().toString());

        newCitizen.occupation = occupationEditText.getText().toString();

        citizenData.add(newCitizen);
    }
    public void buttonHandlerView(View view){
        Intent i = new Intent(this, ViewActivity.class);
        i.putExtra(getString(R.string.citizendata), citizenData);
        i.putExtra(getString(R.string.logged), logged);
        startActivity(i);
        finish();
    }
    public void buttonHandlerClear(View view){
        FragmentManager fm = getSupportFragmentManager();
        DialogFragment alertDialog = ClearAlert.newInstance("Delete data");
        alertDialog.show(fm, "fragment_alert");
    }
    public void clearData(){
        citizenData = logged.clearData(citizenData);
    }
    public void buttonHandlerLogout(View view){
        logged = null;
        Intent logout = new Intent(this, LoginActivity.class);
        logout.putExtra(getString(R.string.citizendata), citizenData);
        startActivity(logout);
        finish();
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region add form fields reference
        religionr1 = (RadioGroup) findViewById(R.id.religionr1);
        religionr2 = (RadioGroup) findViewById(R.id.religionr2);
        religionr3 = (RadioGroup) findViewById(R.id.religionr3);

        NIKEditText = (EditText) findViewById(R.id.NIK);
        nameEditText = (EditText) findViewById(R.id.fullname);
        addressEditText = (EditText) findViewById(R.id.address);
        rtEditText = (EditText) findViewById(R.id.rt);
        rwEditText = (EditText) findViewById(R.id.rw);
        postEditText = (EditText) findViewById(R.id.postalcode);
        villageEditText = (EditText) findViewById(R.id.village);
        districtEditText = (EditText) findViewById(R.id.district);
        cityEditText = (EditText) findViewById(R.id.city);
        provinceEditText = (EditText) findViewById(R.id.province);
        DoBdateEditText = (EditText) findViewById(R.id.DoBdate);
        DoBmonthEditText = (EditText) findViewById(R.id.DoBmonth);
        DoByearEditText = (EditText) findViewById(R.id.DoByear);
        occupationEditText = (EditText) findViewById(R.id.occupation);
        //endregion


    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        logged = i.getSerializableExtra(getString(R.string.logged), User.class);
        Function.isLogged(this, logged);

        if(logged != null)
            logged.initiate(findViewById(R.id.button_clear));

        ArrayList<Citizen> buffer = (ArrayList<Citizen>)i.getSerializableExtra(getString(R.string.citizendata), ArrayList.class);
        if(buffer != null){
            citizenData = buffer;
        }
    }
}