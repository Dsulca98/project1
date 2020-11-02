package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ResultsActivity extends AppCompatActivity {

    TextView mCurrentAttempt,mStoredAttempts,mTitle;
    Button mShowAttempts;
    String  currentMessage;
    static int  savedCorrects,savedIncorrects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        //Initializes Views to java file
        mCurrentAttempt=(TextView)findViewById(R.id.currentAttempt);
        mStoredAttempts=(TextView)findViewById(R.id.storedAttempts);
        mShowAttempts=(Button)findViewById(R.id.availableFile);
        mTitle=(TextView)findViewById(R.id.titleResultsActivity);
        //these are the trackers that are used to display the record of the current user
        //it adds to the current record the number of wrong or correct answers
        savedIncorrects=savedIncorrects+(6-QuizActivity.correctQues);
        savedCorrects=savedCorrects+QuizActivity.correctQues;
        //try and catch will catch the error of IOException
       try {
           //will write to the file by default on activity creation the
            writeToInternalFile(savedCorrects,savedIncorrects);
            String fileContents = readFromInternalFile();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        //on resume will only set the current record right and wrong answer of the user
        String titleText="User: "+MainActivity.getEmail();
        mTitle.setText(titleText);
        currentMessage="Current Attempt\n"+"Correct: "+QuizActivity.correctQues+"\nIncorrect: "+(6-QuizActivity.correctQues);
        mCurrentAttempt.setText(currentMessage);
    }
    public void readData(View view) throws IOException {
        //will read the file
        mStoredAttempts.setText(readFromInternalFile());
    }
    private void writeToInternalFile(int correct, int incorrect) throws IOException {
        //will write to the file using the fileOutPutStream and PrintWriter
        FileOutputStream outputStream = openFileOutput("FileNameHere", Context.MODE_PRIVATE);
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println("Saved Attempt(s):\n"+ "Correct: "+correct+"\nIncorrect: "+incorrect);
        //always close the file
        writer.close();
    }
    public String readFromInternalFile() throws IOException {
        //FileInputStream will allow us to read from file
        FileInputStream inputStream= openFileInput("FileNameHere");
        BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream));
        //Build a string
        StringBuilder stringBuild=new StringBuilder();
        try {
            //in the try catch, building a string
            String question;
            while((question=reader.readLine())!=null)
                stringBuild.append(question).append('\n');
        }
        finally {
            //always close the file
            reader.close();
        }
        //will return current info in file as a string
        return stringBuild.toString();
    }



}