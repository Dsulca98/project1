package com.example.project1;
//libraries used in the program
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
//widget and string variables are created
    TextView mUserEmail;
    String userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
//The program welcomes the user by putting up the screen with their email
//getEmail() is used to retrieve the user's email
        mUserEmail=(TextView)findViewById(R.id.user_email);
        mUserEmail.setText(MainActivity.getEmail());

    }

    public void QuizEnterClick(View view) {
        Intent intentRegister=new Intent(this,QuizActivity.class);
        startActivity(intentRegister);
    }
}