package com.brainstormer.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnFragA,btnFragB,btnFragC;
String ROOT_FRAGMENT="root_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);
        btnFragC = findViewById(R.id.btnFragC);

        loadFrag(new BFragment(),0);
        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFrag(AFragment.getInstance("Rakibul Hassan",3238),1);
            }
        });

        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFrag(new BFragment(),0);
            }
        });

        btnFragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadFrag(new CFragment(),1);
            }
        });
    }

    public  void loadFrag(Fragment fragment, int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


//        Bundle bundle = new Bundle();
//        bundle.putString("Arg1","Rakib");
//        bundle.putInt("Arg2",7);
//
//        fragment.setArguments(bundle);
        if(flag==0){
           ft.add(R.id.container,fragment);
           fm.popBackStack(ROOT_FRAGMENT, FragmentManager.POP_BACK_STACK_INCLUSIVE);
           ft.addToBackStack(ROOT_FRAGMENT);
        }
        else{
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
        }


        ft.commit();
    }

    public void CallFromFragment(){
        Log.d("inAct:","FromFragment");
    }

}