package com.brainstormer.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /*
        AlertDialog alertDialog1 = new AlertDialog.Builder(this).create();
        alertDialog1.setTitle("Terms and condition");
        alertDialog1.setIcon(R.drawable.ic_baseline_info_24);
        alertDialog1.setMessage("Have you accept all the terms and conditions");
        alertDialog1.setButton(DialogInterface.BUTTON_POSITIVE,"Yes, I have accepted all",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Yes, you can procced now...", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog1.show();
      */
        AlertDialog.Builder del_dialog = new AlertDialog.Builder(MainActivity.this);
        del_dialog.setTitle("Delete");
        del_dialog.setIcon(R.drawable.ic_baseline_delete_24);
        del_dialog.setMessage("Are you sure want to delete?");
        del_dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Item deleted", Toast.LENGTH_SHORT).show();
            }
        });
        del_dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Item not deleted", Toast.LENGTH_SHORT).show();
            }
        });
        del_dialog.show();


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exit = new AlertDialog.Builder(this);
        exit.setTitle("Exit");
        exit.setMessage("Are you sure want to exit?");
        exit.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        exit.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Welcome back!", Toast.LENGTH_SHORT).show();
            }
        });
        exit.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });

        exit.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Operation executed", Toast.LENGTH_SHORT).show();
            }
        });
        exit.show();

    }
}