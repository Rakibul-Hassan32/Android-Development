package com.brainstormer.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //default toast
        //Toast.makeText(getApplicationContext(),"Hello world!!!",Toast.LENGTH_LONG).show();

        btn = findViewById(R.id.Btn);
        //custom toast
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = new Toast(getApplicationContext());
                View view1 =  getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup) findViewById(R.id.viewContainer));
                toast.setView(view1);
                TextView txtMassage = view1.findViewById(R.id.txtMassage);
                txtMassage.setText("Massage sent Successfully.");
                toast.setDuration(Toast.LENGTH_LONG);

                toast.setGravity(Gravity.CENTER|Gravity.TOP, 0,0);

                toast.show();
            }
        });

    }
}