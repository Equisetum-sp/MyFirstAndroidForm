package com.example.uts3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ClearAlert extends DialogFragment {
    //static boolean res;
    public static ClearAlert newInstance(String title) {
        ClearAlert frag = new ClearAlert();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }
    /*
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete data");
        builder.setMessage("Are you sure you want to delete all data?");
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Delete data
                ClearAlert.res = true;
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                ClearAlert.res = false;
            }
        });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    public static boolean getRes() {
        Log.d("ClearAlertResult", Boolean.valueOf(res).toString());
        return res;
    }

     */
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setTitle("Delete data")
                .setMessage("Are you sure you want to delete all data?")
                .setPositiveButton("Yes",
                        (dialogInterface, i) -> ((MainActivity)getActivity()).clearData())
                .setNegativeButton("No",
                        (dialogInterface, i) -> {})
                .create();
        //return super.onCreateDialog(savedInstanceState);
    }
}
