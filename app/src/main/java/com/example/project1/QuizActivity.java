package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private  TextView mQuestionBubble;
    private  RadioGroup mRadioGroup;
    private  RadioButton mAnswerBubble1, mAnswerBubble2, mAnswerBubble3, mAnswerBubble4;
    private TextView mFragmentMessage;
    private Button mFragmentButton;
    static int correctQues;
    static int quesTracker;
    static final int NUM_QUESTIONS=6;
    static final int NUM_ANSWERS=4;
    static String  [] quesArr=new String[NUM_QUESTIONS];
    static String ans1,ans2,ans3,ans4,ans5,ans6;
    static String [] ansArr=new String[NUM_ANSWERS];
    static String fragmentMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //Linking the Views to java file
        mQuestionBubble=(TextView)findViewById(R.id.questionBubble);
        mRadioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        mAnswerBubble1=(RadioButton) findViewById(R.id.radioBubble1);
        mAnswerBubble2=(RadioButton)findViewById(R.id.radioBubble2);
        mAnswerBubble3=(RadioButton)findViewById(R.id.radioBubble3);
        mAnswerBubble4=(RadioButton)findViewById(R.id.radioBubble4);
        mFragmentMessage=(TextView)findViewById(R.id.fragment_textview);
        //Initializing trackers, questions and answers
        correctQues=0;
        quesTracker=1;
        createQuestions();
        createAnswers();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //setting the questions and answers on the screen
        setQuestion(quesArr,quesTracker);
        ansArr=setAns(quesTracker);
    }

    public void setQuestion(String [] myQuestion, int quesTracker)
    {
        if(quesTracker==6)//question 6 and are on a different activity, they are multiple answer questions
        {//call to calMA()
            callMA(); }
        else {
            //if it is not question 6, call set the question
            mQuestionBubble.setText(myQuestion[quesTracker - 1]);
        }
    }

    public String[] setAns(int quesTracker){
        //answers are stored in each array for each question
        String []temp1=ans1.split(",");
        String []temp2=ans2.split(",");
        String []temp3=ans3.split(",");
        String []temp4=ans4.split(",");
        String []temp5=ans5.split(",");
//the if statements depending on the questions will set the corresponding answer to the array
        if(quesTracker==1){
            mAnswerBubble1.setText(temp1[0]);
            mAnswerBubble2.setText(temp1[1]);
            mAnswerBubble3.setText(temp1[2]);
            mAnswerBubble4.setText(temp1[3]);
            return temp1;
        }
        else if(quesTracker==2){
            mAnswerBubble1.setText(temp2[0]);
            mAnswerBubble2.setText(temp2[1]);
            mAnswerBubble3.setText(temp2[2]);
            mAnswerBubble4.setText(temp2[3]);
            return temp2;
        }
        else if(quesTracker==3){
            mAnswerBubble1.setText(temp3[0]);
            mAnswerBubble2.setText(temp3[1]);
            mAnswerBubble3.setText(temp3[2]);
            mAnswerBubble4.setText(temp3[3]);
            return temp3;
        }
        else if(quesTracker==4){
            mAnswerBubble1.setText(temp4[0]);
            mAnswerBubble2.setText(temp4[1]);
            mAnswerBubble3.setText(temp4[2]);
            mAnswerBubble4.setText(temp4[3]);
            return temp4;
        }
        else //if(quesTracker==5)
        {
            mAnswerBubble1.setText(temp5[0]);
            mAnswerBubble2.setText(temp5[1]);
            mAnswerBubble3.setText(temp5[2]);
            mAnswerBubble4.setText(temp5[3]);
            return temp5;
        }
    }
    public boolean verifyAns() {
        //verify answer by comparing the selected answer to an answer key
        String tempKey=getResources().getString(R.string.Answer_key);
        String[]ansKey=tempKey.split(",");
        //is able to get the ID from the radioButton selected
        int checkedID=mRadioGroup.getCheckedRadioButtonId();
        //has to be the current answer set
        //if the selected answer and the key matches, the answer will return true
        if(mAnswerBubble1==findViewById(checkedID))
        {
            if(ansKey[quesTracker-1].equals(ansArr[0])){
                return true;
            }
        }
        if(mAnswerBubble2==findViewById(checkedID))
        {
            if(ansKey[quesTracker-1].equals(ansArr[1])){
                return true;
            }
        }
        if(mAnswerBubble3==findViewById(checkedID))
        {
            if(ansKey[quesTracker-1].equals(ansArr[2])){
                return true;
            }
        }
        if(mAnswerBubble4==findViewById(checkedID))
        {
            if(ansKey[quesTracker-1].equals(ansArr[3])){
                return true;
            }
        }
        //else it will return false
        return false;
    }
    public void selectAnswer(View view) {
        //retrieves the ID from checked radioButton
        int checkedID=mRadioGroup.getCheckedRadioButtonId();
        //call the verifyAns function to check if the answer is correct, boolean
        boolean checkedAns=verifyAns();
        //if no answer is selected,the user is forced to press an answer
        if(checkedID==-1) {
            fragmentMessage="Choose an option";
            Toast.makeText(getApplicationContext(),fragmentMessage,Toast.LENGTH_SHORT).show();
        }
        //if true, the correctQues and question number will increment, a message will show and new question ans answer will show
        else if(checkedAns==true)
        {
            correctQues++;
            fragmentMessage="correct answer";
            Toast.makeText(getApplicationContext(),fragmentMessage,Toast.LENGTH_SHORT).show();
            quesTracker++;
            setQuestion(quesArr,quesTracker);
            ansArr=setAns(quesTracker);
        }
        //if false, a message will show and new question and answer will set , incrementing the question number
        else if(checkedAns==false)
        {
            fragmentMessage="Wrong Answer";
            Toast.makeText(getApplicationContext(),fragmentMessage,Toast.LENGTH_SHORT).show();
            quesTracker++;
            setQuestion(quesArr,quesTracker);
            ansArr=setAns(quesTracker);
        }
    }
    //will create initialize questions into an array at onCreate()
    public void createQuestions()
    {
        //get Questions from resource file
        quesArr[0]=getResources().getString(R.string.question1);
        quesArr[1]=getResources().getString(R.string.question2);
        quesArr[2]=getResources().getString(R.string.question3);
        quesArr[3]=getResources().getString(R.string.question4);
        quesArr[4]=getResources().getString(R.string.question5);
        quesArr[5]=getResources().getString(R.string.question6);
    }
    //will create the answers on different string at onCreate()
    public void createAnswers()
    {
        //get the answers from the resource file
        ans1=getResources().getString(R.string.answer1);
        ans2=getResources().getString(R.string.answer2);
        ans3=getResources().getString(R.string.answer3);
        ans4=getResources().getString(R.string.answer4);
        ans5=getResources().getString(R.string.answer5);
        ans6=getResources().getString(R.string.answer6);
    }
    //intent will call the new multiple answer activity and finish this activity so the user cannot go back to this activity
    public void callMA()
    {
        Intent intentMA = new Intent(QuizActivity.this, MultipleAnswerActivity.class);
        //The method startActivity() starts specified activity
        startActivity(intentMA);
        this.finish();
    }
 }