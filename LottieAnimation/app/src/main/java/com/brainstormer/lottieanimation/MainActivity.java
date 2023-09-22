package com.brainstormer.lottieanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
LottieAnimationView loView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*loView.setAnimation(R.raw.lottie);
        loView.playAnimation();
        loView.loop(true);*/

    }
}