package com.brainstormer.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //getting intent information
        Intent fromAct = getIntent();

        //fetching data
        String title = fromAct.getStringExtra("title");//Home
        String StudentName = fromAct.getStringExtra("StudentName");//Rakib
        int rollNo = fromAct.getIntExtra("Roll No", 0);//10

        TextView txtStudentInfo;
        txtStudentInfo = findViewById(R.id.txtStudentInfo);

        txtStudentInfo.setText("Roll No: "+rollNo+", Name: "+StudentName);

        //setting new tittle
        getSupportActionBar().setTitle(title);//Home
    }
}