package com.brainstormer.intentpassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    ///from one interface(activity) to another
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext;
        btnNext = findViewById(R.id.btnNext);

        //another activity' object and two parameters from source to destination
        //intent class is the class which will appear first when we open a app
        Intent iNext;
        iNext = new Intent(MainActivity.this, SecondActivity.class);

        iNext.putExtra("title", "Home");
        iNext.putExtra("StudentName", "Rakib");
        iNext.putExtra("Roll No", 10);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to next activity after click
                startActivity(iNext);
            }
        });

    }
}