package com.brainstormer.customtoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        //step 01
        setSupportActionBar(toolbar);

        //step 02
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My Toolbar");
        }

        //toolbar.setTitle("My Toolbar");
        toolbar.setSubtitle("Sub tittle");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if(item_id == R.id.opt_new){
            Toast.makeText(this, "Created new file", Toast.LENGTH_SHORT).show();
        }
        else if(item_id == R.id.opt_open){
            Toast.makeText(this, "File opened", Toast.LENGTH_SHORT).show();
        }
        else if(item_id == android.R.id.home){
            super.onBackPressed();
        }
        else{

            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}