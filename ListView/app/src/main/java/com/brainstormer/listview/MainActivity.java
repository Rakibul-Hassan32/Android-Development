package com.brainstormer.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //different type of listview's object
ListView listView;
Spinner spinner;
AutoCompleteTextView autoComplete;

    //initializing arraylist to use them
ArrayList<String> arrNames = new ArrayList<>();
ArrayList<String> arrIds = new ArrayList<>();
ArrayList<String> arrLanguage=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //connecting xml id's with java
        listView=findViewById(R.id.listView);
        spinner=findViewById(R.id.spinner);
        autoComplete = findViewById(R.id.autoComplete);


                              //listview

        //putting datas in listview(linear vertically and scrollable
        arrNames.add("Rakib");
        arrNames.add("Sany");
        arrNames.add("Johirul");
        arrNames.add("Soyad");
        arrNames.add("Sahil");
        arrNames.add("Hannan");
        arrNames.add("Bipu");
        arrNames.add("Mostafiz");
        arrNames.add("Nijhum");
        arrNames.add("Rakib");
        arrNames.add("Sany");
        arrNames.add("Johirul");
        arrNames.add("Soyad");
        arrNames.add("Sahil");
        arrNames.add("Hannan");
        arrNames.add("Bipu");
        arrNames.add("Mostafiz");
        arrNames.add("Nijhum");
        arrNames.add("Rakib");
        arrNames.add("Sany");
        arrNames.add("Johirul");
        arrNames.add("Soyad");
        arrNames.add("Sahil");
        arrNames.add("Hannan");
        arrNames.add("Bipu");
        arrNames.add("Mostafiz");
        arrNames.add("Nijhum");
        arrNames.add("Rakib");
        arrNames.add("Sany");
        arrNames.add("Johirul");
        arrNames.add("Soyad");
        arrNames.add("Sahil");
        arrNames.add("Hannan");
        arrNames.add("Bipu");
        arrNames.add("Mostafiz");
        arrNames.add("Nijhum");
        arrNames.add("Rakib");
        arrNames.add("Sany");
        arrNames.add("Johirul");
        arrNames.add("Soyad");
        arrNames.add("Sahil");
        arrNames.add("Hannan");
        arrNames.add("Bipu");
        arrNames.add("Mostafiz");
        arrNames.add("Nijhum");
        arrNames.add("Rakib");
        arrNames.add("Sany");
        arrNames.add("Johirul");
        arrNames.add("Soyad");
        arrNames.add("Sahil");
        arrNames.add("Hannan");
        arrNames.add("Bipu");
        arrNames.add("Mostafiz");
        arrNames.add("Nijhum");
        arrNames.add("Rakib");
        arrNames.add("Sany");
        arrNames.add("Johirul");
        arrNames.add("Soyad");
        arrNames.add("Sahil");
        arrNames.add("Hannan");
        arrNames.add("Bipu");
        arrNames.add("Mostafiz");
        arrNames.add("Nijhum");
        arrNames.add("Rakib");
        arrNames.add("Sany");
        arrNames.add("Johirul");
        arrNames.add("Soyad");
        arrNames.add("Sahil");
        arrNames.add("Hannan");
        arrNames.add("Bipu");
        arrNames.add("Mostafiz");
        arrNames.add("Nijhum");

        //creating a machine or adapter to show my datas
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrNames);

        //persing the adapter in listview's object to execute
        listView.setAdapter(adapter);

        //perform on click operations
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0){
                    Toast.makeText(MainActivity.this, "Clicked first item", Toast.LENGTH_SHORT).show();
                }
                else if(position%2==0){
                    Toast.makeText(MainActivity.this, "Clicked odd item", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Clicked even item", Toast.LENGTH_SHORT).show();
                }
            }
        });


                                       //spinner view

        arrIds.add("National Id Card");
        arrIds.add("Driving License Card");
        arrIds.add("SSC certification Card");
        arrIds.add("HSC certifiication Card");
        arrIds.add("University Id Card");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrIds);
        spinner.setAdapter(spinnerAdapter);


                                    //Auto complete textview
        arrLanguage.add("Kamar");
        arrLanguage.add("Kumar");
        arrLanguage.add("Tati");
        arrLanguage.add("Jele");
        arrLanguage.add("Sikhok");
        arrLanguage.add("Bebsai");
        arrLanguage.add("Chakrijibi");

        ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrLanguage);
        autoComplete.setAdapter(autoCompleteAdapter);

        //Threshold to recommend words after input
        autoComplete.setThreshold(1);


    }
}