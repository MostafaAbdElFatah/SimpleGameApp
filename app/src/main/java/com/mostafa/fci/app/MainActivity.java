package com.mostafa.fci.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Global Variables
    int score = 0;
    Boolean isFirstGrading = true;
    Button question1, question2, question3, question4;
    //override method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initalize views
        question1 = findViewById(R.id.submitButton1);
        question2 = findViewById(R.id.submitButton2);
        question3 = findViewById(R.id.submitButton3);
        question4 = findViewById(R.id.submitButton4);
    }
    // Check Question 1 Answer
    public void submitQuestion1(View view) {
        EditText answerEditText =  findViewById(R.id.question_1_Answer);
        String answer = answerEditText.getText().toString();
        //check EditText is empty or not
        if (answer.equals("")){
            Toast.makeText(this,"Please Enter answer Question",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this,"Answer Submit"
                ,Toast.LENGTH_LONG).show();
        //disEnable Question
        view.setEnabled(false);
        answerEditText.setEnabled(false);
    }
    // Check Question 2 Answer
    public void submitQuestion2(View view) {
        if (question1.isEnabled()){
            Toast.makeText(this,"Answer The above Questions"
                    ,Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this,"Answer Submit"
                ,Toast.LENGTH_LONG).show();
        view.setEnabled(false);
        View[] answers = {findViewById(R.id.question_2_answer1)
                ,findViewById(R.id.question_2_answer2)
                ,findViewById(R.id.question_2_answer3)
                ,findViewById(R.id.question_2_answer4)};
        for (int i = 0 ; i <answers.length ;i++ ){
            answers[i].setEnabled(false);
        }
    }
    // Check Question 3 Answer
    public void submitQuestion3(View view) {
        if (question2.isEnabled()){
            Toast.makeText(this,"Answer The above Questions"
                    ,Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this,"Answer Submit"
                ,Toast.LENGTH_LONG).show();
        view.setEnabled(false);
        View[] answers = {findViewById(R.id.question_3_answer1)
                ,findViewById(R.id.question_3_answer2)
                ,findViewById(R.id.question_3_answer3)};
        for (int i = 0 ; i <answers.length ;i++ ){
            answers[i].setEnabled(false);
        }
    }
    // Check Question 4 Answer
    public void submitQuestion4(View view) {
        if (question3.isEnabled()){
            Toast.makeText(this,"Answer The above Questions"
                    ,Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this,"Answer Submit"
                ,Toast.LENGTH_LONG).show();
        view.setEnabled(false);
        View[] answers = {findViewById(R.id.question_4_answer1)
                ,findViewById(R.id.question_4_answer2)
                ,findViewById(R.id.question_4_answer3)};
        for (int i = 0 ; i <answers.length ;i++ ){
            answers[i].setEnabled(false);
        }
    }

    public void displayGrading(View view) {
        if (question4.isEnabled()){
            Toast.makeText(this,"Answer The above Questions"
                    ,Toast.LENGTH_LONG).show();
            return;
        }
        checkAnswers();
        displayGradingOfQuestion();
    }

    private void displayGradingOfQuestion() {
        Toast.makeText(this, "The Correct Answer:" + score + " From 4"
                        + "\nthe Wrong Answers:"+ (4 - score) +" From 4"
                , Toast.LENGTH_LONG).show();
    }

    public void checkAnswers(){
        if (isFirstGrading) {
            isFirstGrading = false;
        }else {
            return;
        }
        String answer;
        // check answer 1
        answer = ((EditText)findViewById(R.id.question_1_Answer)).getText().toString();
        if (answer.toLowerCase().equals("cairo")) {
            score += 1;
        }
        //check Answer 2
        Boolean[] answers = {((CheckBox)findViewById(R.id.question_2_answer1)).isChecked()
                ,((CheckBox)findViewById(R.id.question_2_answer2)).isChecked()
                ,((CheckBox)findViewById(R.id.question_2_answer3)).isChecked()
                ,((CheckBox)findViewById(R.id.question_2_answer4)).isChecked()};
        //number of answer of question
        // check the correct MultiAnswer
        if ( (answers[0]== true && answers[2] == true) &&
                (answers[1]== false && answers[3] == false)){
            score += 1;
        }
        // check answer 3
        RadioGroup radioGroup = findViewById(R.id.question_3_answers);
        answer = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId()))
                .getText().toString();
        //number of answer of question
        // check answer
        if (answer.equals("Ottawa")) {
            score += 1;
        }
        // check answer 4
        radioGroup = findViewById(R.id.question_4_answers);
        answer = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId()))
                .getText().toString();
        //number of answer of question
        // check answer
        if (answer.equals("Canberra")) {
            score += 1;
        }
    }

}
