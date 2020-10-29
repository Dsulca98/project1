package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView mQuestionBubble;
    private RadioGroup mRadioGroup;
    private RadioButton mAnswerBubble1;
    private RadioButton mAnswerBubble2;
    private RadioButton mAnswerBubble3;
    private RadioButton mAnswerBubble4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mQuestionBubble=(TextView)findViewById(R.id.questionBubble);
        mRadioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        mAnswerBubble1=(RadioButton)findViewById(R.id.radioBubble1);
        mAnswerBubble2=(RadioButton)findViewById(R.id.radioBubble2);
        mAnswerBubble3=(RadioButton)findViewById(R.id.radioBubble3);
        mAnswerBubble4=(RadioButton)findViewById(R.id.radioBubble4);

    }
//try to create a farment during runtime to show that the answer is correct or incorrect
    @Override
    protected void onStart() {
        super.onStart();
        setQuestions();
    }
    public void setQuestions(){
        //set the questions for the radio buttons, should be random
    }

    public void selectAnswer(View view) {
    }
}