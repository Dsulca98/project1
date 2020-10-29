package com.example.project1;
//libraries used in the program
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    //created the MainActivity fields to Android.Widget classes
    private TextView mMessage;
    private EditText mNewFirstName;
    private EditText mNewLastName;
    /*mNewDateOfBirth is not used, I was not able to convert the TextView into an int
    * the code is explained in line 76*/
    private EditText mNewDateOfBirth;
    private EditText mNewEmail;
    private EditText mNewPassword;
    private EditText mConfirmPassword;
    //created String variables to contain the text from user input
    private String newFirstName;
    private String newLastName;
    private String newEmail;
    private String newPassWord;
    private String confirmPassword;
    private String message;
    //NewDateOfBirth was an int
    private String newDateOfBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_register);
        super.onCreate(savedInstanceState);
//findViewById returns a reference to a view by using the view's id as an argument
//It is casted to the specific Widget class to make sure there is no problems
        mMessage=(TextView)findViewById(R.id.register_message);
        mNewFirstName = (EditText) findViewById(R.id.text_new_first_name);
        mNewLastName=(EditText) findViewById(R.id.text_new_last_name);
        mNewDateOfBirth=(EditText) findViewById(R.id.editTextDate);
        mNewEmail=(EditText) findViewById(R.id.text_new_email_address);
        mNewPassword = (EditText) findViewById(R.id.text_new_password);
        mConfirmPassword=(EditText) findViewById(R.id.text_confirm_password);
    }


//this register process click is similar to the one in MainActivity
//the purpose is to validate and start return the user to the MainActivity if the input is correct
    public void RegisterProcessClick(View view) {
//Because there are more widget used in this activity, I outsourced the convertion into a String into
//processData() function
        processData();
//if the validateData() returns true, the if statement will send a message if not, it will return the
//user to the MainActivity to login
        if(validateData()){
            mMessage.setText(message);
        }
        else {
            message="Registration Successful";
            mMessage.setText(message);
//intentRegister is an Intent variable(object) initialized to call Register activity
             Intent intentMain = new Intent(RegisterActivity.this, MainActivity.class);
//The method startActivity() starts specified activity inside intentRegister
             startActivity(intentMain);
         }
    }


    //findViewById returns a reference to a view by using the view's id as an argument
//It is casted to the specific Widget class to make sure there is no problems
    public void processData(){
        newFirstName=mNewFirstName.getText().toString();
        newLastName=mNewLastName.getText().toString();
        newDateOfBirth= mNewDateOfBirth.getText().toString();
       /* String strBirth=mNewDateOfBirth.getText().toString();
        newDateOfBirth=Integer.parseInt(strBirth);
         I was not able to convert the date of birth TextView into an int for validation, the
        program kept crashing*/
        newEmail=mNewEmail.getText().toString();
        newPassWord=mNewPassword.getText().toString();
        confirmPassword=mConfirmPassword.getText().toString();
    }



//validateData() returns a boolean to registerProcessClick()

    public boolean validateData(){
//This is the same code used in MainActivity as a validation method for the email widget
        Pattern dateOfBirth=Pattern.compile("^../../....$");
        Matcher findDateOfBirth=dateOfBirth.matcher(newDateOfBirth);

        Pattern pattern=Pattern.compile("@farmingdale.edu");
        Matcher findEmail=pattern.matcher(newEmail);
//makes sure that the user has entered the fields asked for
        if (newFirstName.equals("")||newLastName.equals("")||newEmail.equals("")||newPassWord.equals("")||confirmPassword.equals("")) {
            message="Invalid!! Try Again";
            return true;
        }
//the name cannot be less than 3 or more than 30 characters
        else if(newFirstName.length() < 3 || newFirstName.length() > 30){
            message="Invalid Name";
            return true;
        }
//The last name cannot be less than 3 or more than 30
        else if(newLastName.length()< 3 || newLastName.length()> 30){
            message="Invalid Last Name";
            return true;
        }
//Password length must be at least 5 characters and no more then 15
        else if(newPassWord.length()< 5|| newPassWord.length()> 15) {
            message="Invalid Password";
            return true;
//This makes sure the passwords match
        } if(!(newPassWord.equals(confirmPassword))){
            message="Password Does Not Match";
            return true;
        }
//works with the regex library and returns a boolean value whether a match is found
        else if(!(findEmail.find())){
            message="Invalid Email";
            return true;
        }
//validation of date
        else if(!(findDateOfBirth.find())){
            message="Invalid Date of Birth";
            return true;
        }
//if the program reaches here, then the app will start the new activity
        else{return false;}
    }

}
