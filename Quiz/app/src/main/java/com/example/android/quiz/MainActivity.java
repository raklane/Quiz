package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //totalCorrectAnswers keeps count of total number of correct answers
    private int totalCorrectAnswers = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method unchecks all the radio buttons
     */
    public void resetAnswers(View view){
        int totalNumberOfQuestions = Integer.parseInt(getString(R.string.totalNumberOfQuestions));
        String radioButtonId;
        int resId;
        for(int i=1; i<=totalNumberOfQuestions ;i++){
            for(int j=1; j<=4 ;j++){
                radioButtonId = "q" + i + "a" + j;
                resId = getResources().getIdentifier(radioButtonId,"id",getPackageName());
                RadioButton radioButton = (RadioButton) findViewById(resId);
                radioButton.setChecked(false);
            }//for every answer
        }//for every question
    }

    /**
     * This method counts the number of correct answers
     */
    public void countCorrectAnswers(View view){
        int totalNumberOfQuestions = Integer.parseInt(getString(R.string.totalNumberOfQuestions));
        String radioButtonId;
        int currentCorrectAnswer;
        Boolean correctAnswer;
        int resId;
        for(int i=1; i<=totalNumberOfQuestions ;i++){
            currentCorrectAnswer = Integer.parseInt(String.valueOf(getString(R.string.correctAnswers).charAt(i-1)));
            correctAnswer = false;
            for(int j=1; j<=4 ;j++){
                radioButtonId = "q" + i + "a" + j;
                resId = getResources().getIdentifier(radioButtonId,"id",getPackageName());
                RadioButton radioButton = (RadioButton) findViewById(resId);
                if(radioButton.isChecked()){
                    if(j!=currentCorrectAnswer){
                        correctAnswer = false;
                        break;
                    }else
                        correctAnswer = true;
                }
            }//for every answer
            if(correctAnswer==true)
                totalCorrectAnswers = totalCorrectAnswers + 1;
        }//for every question
        //Display the total number of correct answers in a toast message
        Toast.makeText(getApplicationContext(),"Total correct answers: " + totalCorrectAnswers, Toast.LENGTH_LONG).show();
        totalCorrectAnswers = 0;
    }

}
