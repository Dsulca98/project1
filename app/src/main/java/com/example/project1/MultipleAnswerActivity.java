package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MultipleAnswerActivity extends AppCompatActivity {
    //creating the views to use in java
    CheckBox mCheckBubble1,mCheckBubble2,mCheckBubble3,mCheckBubble4;
    TextView mQuestionBubble;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_answer);
        //Linking the Views to the java file
        mCheckBubble1=(CheckBox)findViewById(R.id.checkBubble1);
        mCheckBubble2=(CheckBox)findViewById(R.id.checkBubble2);
        mCheckBubble3=(CheckBox)findViewById(R.id.checkBubble3);
        mCheckBubble4=(CheckBox)findViewById(R.id.checkBubble4);
        mQuestionBubble=(TextView)findViewById(R.id.questionBubble);
    }
    @Override
    protected void onResume() {
        super.onResume();
        //calling the functions to set the question and answer
        setQuestion(QuizActivity.quesArr,QuizActivity.quesTracker);
        QuizActivity.ansArr=setAns(QuizActivity.quesTracker);
    }
    public void setQuestion(String [] myQuestion, int quesTracker)
    {
        //setting the question if it is not question 7, if it is, it will call an intent
        if(quesTracker==7)
        {
            callResults();
        }
        else {
        mQuestionBubble.setText(myQuestion[quesTracker-1]);}
    }
    public String[] setAns(int quesTracker){
        //answers are stored in each array for each question
        String []temp6=QuizActivity.ans6.split(",");
            mCheckBubble1.setText(temp6[0]);
            mCheckBubble2.setText(temp6[1]);
            mCheckBubble3.setText(temp6[2]);
            mCheckBubble4.setText(temp6[3]);
            //In this case it only return temp6 because it is the only Multiple answer question
            return temp6;
    }
        public void selectAnswerMA(View view) {
            //will return if the selected checkboxes are correct into boolean
            boolean checkedAns = verifyMA();
            //if true, the correctQues and question number will increment, a message will show and new question ans answer will show
            if (checkedAns == true) {
                QuizActivity.correctQues++;
                QuizActivity.quesTracker++;
                QuizActivity.fragmentMessage = "Correct answer";
                Toast.makeText(getApplicationContext(), QuizActivity.fragmentMessage, Toast.LENGTH_SHORT).show();
                setQuestion(QuizActivity.quesArr, QuizActivity.quesTracker);
            }
            //if false, a message will show and new question and answer will set , incrementing the question number
            else if (checkedAns == false) {
                QuizActivity.quesTracker++;
                QuizActivity.fragmentMessage = "Wrong answer";
                Toast.makeText(getApplicationContext(), QuizActivity.fragmentMessage, Toast.LENGTH_SHORT).show();
                setQuestion(QuizActivity.quesArr, QuizActivity.quesTracker);
            }
        }
        //verifies if question 6 is correct
    public boolean verifyMA() {
        return mCheckBubble1.isChecked() && mCheckBubble2.isChecked() && mCheckBubble3.isChecked();
    }
    //this call the final activity for the quiz, the results, and finishing this activity so the user cannot return
    public void callResults(){
        Intent intentResults = new Intent(MultipleAnswerActivity.this, ResultsActivity.class);
        //The method startActivity() starts specified activity
        startActivity(intentResults);
        this.finish();
    }
}




