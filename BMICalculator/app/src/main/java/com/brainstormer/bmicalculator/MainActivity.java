package com.brainstormer.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///craeting variables of xml buttons class
        TextView txtResult;
        EditText edtWeight, edtHeight, edtHeight1;
        Button btnCalculate;
        LinearLayout llMain;

        //fetch the values from ui to java in those variables
        edtWeight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        edtHeight1 = findViewById(R.id.edtHeight1);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);

        //On click operation
        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
             int wt = Integer.parseInt(edtWeight.getText().toString());
                int ht = Integer.parseInt(edtHeight.getText().toString());
                int ht1 = Integer.parseInt(edtHeight1.getText().toString());

                int totalIn = ht*12 + ht1;//converting total height into inches
                double totalCm = totalIn*2.53;//converting into centi meters
                double totalMeter = totalCm/100;//converting into meters
                double BMI = wt/(totalMeter*totalMeter);//calculating BMI

                if(BMI > 25){
                    txtResult.setText("You are overWeight fatso, thoda kam khaya kar lodu");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOt));
                }
                else if(BMI<18){
                    txtResult.setText("You are underWeight, kuch kha bhi lee bhai");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUt));
                }
                else{
                    txtResult.setText("You are healthy, keep it up");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorPt));
                }

            }
        });

    }
}