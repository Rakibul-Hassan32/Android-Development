package com.brainstormer.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView btmNaView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btmNaView = findViewById(R.id.btmNaView);

        btmNaView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id ==R.id.nav_home){
                    loadFrag(new AFragment(),0);
                }else if(id == R.id.nav_search){
                    loadFrag(new BFragment(),0);
                }else if(id == R.id.nav_utilities){
                    loadFrag(new CFragment(),0);
                }else if(id == R.id.nav_contact){
                    loadFrag(new DFragment(),0);
                }else{
                    loadFrag(new EFragment(),1);
                }
                return true;
            }
        });

        btmNaView.setSelectedItemId(R.id.nav_profile);
    }
    public  void loadFrag(Fragment fragment,int a){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(a==1) {
            ft.add(R.id.container, fragment);
        }else{
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }

}