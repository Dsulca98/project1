package com.example.project1;
//libraries used in the program
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//allows the SplashScreen to run first
//postDelayed handles the time in milliseconds how long is the SplashScreen is on
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//the intent is used to start the activity and finish() destroys the Splashscreen Activity
                Intent activityMain =new Intent(SplashScreen.this,MainActivity.class);
                startActivity(activityMain);
                finish();
            }
        },2000);

    }
}