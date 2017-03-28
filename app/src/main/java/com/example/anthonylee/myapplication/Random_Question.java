package com.example.anthonylee.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Random_Question extends AppCompatActivity {

    private Spinner answer_choice1;
    private Spinner answer_choice2;
    private Spinner answer_choice3;
    private ArrayList<String> choise1 = new ArrayList<String>();
    private ArrayList<String> choise2 = new ArrayList<String>();
    private ArrayList<String> choise3 = new ArrayList<String>();
    private ArrayList<String> choise4 = new ArrayList<String>();
    private ArrayList<String> question = new ArrayList<String>();
    private ArrayList<String> q_choice1 = new ArrayList<String>();
    private ArrayList<String> q_choice2 = new ArrayList<String>();
    private ArrayList<String> q_choice3 = new ArrayList<String>();
    private String question1;
    private String question2;
    private String question3;
    private TextView question_text1;
    private TextView question_text2;
    private TextView question_text3;
    private int[] choice_index = new  int[]{R.array.question1, R.array.question2, R.array.question3, R.array.question4, R.array.question5, R.array.question6, R.array.question7, R.array.question8, R.array.question9, R.array.question10};
    private int[] question_index = new  int[]{R.string.question1, R.string.question2, R.string.question3, R.string.question4, R.string.question5, R.string.question6, R.string.question7, R.string.question8, R.string.question9, R.string.question10};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

        int min = 0;
        int max = 9;
        int[] qmark = {55, 58, 50};
        for (int j = 0; j < 3; j++) {
            int Random = (int) (Math.random() * (max - min + 1) + min);
            qmark[j] = Random;
            if (qmark[0] == qmark[1]) {
                j = j - 1;
            }
            if (qmark[0] == qmark[2]) {
                j = j - 1;
            }
            if (qmark[1] == qmark[2]) {
                j = j - 1;
            }
        }



        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, choice_index[qmark[0]], android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, choice_index[qmark[1]], android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, choice_index[qmark[2]], android.R.layout.simple_spinner_item);

        answer_choice1 = (Spinner) findViewById(R.id.question_spinner1);
        answer_choice2 = (Spinner) findViewById(R.id.question_spinner2);
        answer_choice3 = (Spinner) findViewById(R.id.question_spinner3);
        question_text1 = (TextView) findViewById(R.id.question_text1);
        question_text2 = (TextView) findViewById(R.id.question_text2);
        question_text3 = (TextView) findViewById(R.id.question_text3);



        question1 = getResources().getString(question_index[qmark[0]]);
        question2 = getResources().getString(question_index[qmark[1]]);
        question3 = getResources().getString(question_index[qmark[2]]);


        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        answer_choice1.setAdapter(adapter1);
        answer_choice2.setAdapter(adapter2);
        answer_choice3.setAdapter(adapter3);
        question_text1.setText(question1);
        question_text2.setText(question2);
        question_text3.setText(question3);


    }
}
