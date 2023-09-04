package com.example.quizapplication;

import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;

public class ProgramQuestions extends AppCompatActivity {
    int fcheck=0;
    public static int marks=0;
    public static int correctans=0;
    public static int incorrectans=0;
    Button leavebtn,nextbtn;
    RadioButton op_1,op_2,op_3,op_4;
    TextView quest;
    RadioGroup rgrp_answer;
    String ansarray[] = {"It provides input and output functionalities","int array[3] = {1, 2, 3}",
            "private","It compares two objects for equality","<a>",
            "It allows you to assign a class to one or more HTML elements, allowing CSS styling to be applied",
            "<?start_php","It inserts the content of another PHP file at the specified location",
            "onCreate() and onResume()","To define the structure and appearance of the user interface"};

    String choices_array[] = {
            "It provides input and output functionalities","It defines mathematical operations","It handles exceptions","It manages memory allocation",
            "array = {1, 2, 3}","array[] = {1, 2, 3}","int array[3] = {1, 2, 3}","int array = [1, 2, 3]",
            "protected","private","public","default",
            "It compares two primitive data types","It compares two objects for equality","It converts a string to lowercase","It calculates the mathematical equality of two numbers",
            "<link>","<a>","<hyperlink>","<url>",
            "It defines the style of an element","It specifies a unique identifier for an element","It associates an element with a JavaScript function","It allows you to assign a class to one or more HTML elements, allowing CSS styling to be applied",
            "<?php","<? script","<?start_php","<?begin_php",
            "It includes an external CSS file","It imports data from a database","It inserts the content of another PHP file at the specified location","It defines a new class for object-oriented programming",
            "onStart() and onCreate()","onCreate() and onResume()","onResume() and onCreate()","onPause() and onCreate()",
            "To store Java code for handling UI events","To define the structure and appearance of the user interface","To manage background tasks and services","To define data models for the app"};
    String Questnarray[] = {
            "Q: What is the purpose of the \"iostream\" library in C++?",
            "Q: What is the correct way to initialize an array in C++?",
            "Q: Which access modifier in Java makes a method or variable accessible only within the same class?",
            "Q: What is the purpose of the \"equals\" method in Java?",
            "Q: In HTML, which tag is used to create a hyperlink?",
            "Q: What is the purpose of the \"class\" attribute in HTML and CSS?",
            "Q: How do you start a PHP block of code?",
            "Q: What is the purpose of the \"include\" function in PHP?",
            "Q: In Android, which methods are called when an activity is first created and when it's brought to the foreground after being paused?",
            "Q: What is the primary purpose of the XML layout files in Android app development?"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_questions);

        ids();
        final TextView Score = findViewById(R.id.tvscrnum);
        setoptions();

        leavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ProgramQuestions.this,MainActivity.class);
                startActivity(in);
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rgrp_answer.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(ProgramQuestions.this, "select option to proceed", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton temp = (RadioButton) findViewById(rgrp_answer.getCheckedRadioButtonId());
                String store = temp.getText().toString();

                if(store.equals(ansarray[fcheck])) {
                    correctans = correctans + 1;
                    Toast.makeText(ProgramQuestions.this, "Correct Answer !!", Toast.LENGTH_SHORT).show();
                }
                else {
                    incorrectans = incorrectans +1;
                    Toast.makeText(ProgramQuestions.this, "Incorrect Answer !!", Toast.LENGTH_SHORT).show();
                }
                fcheck = fcheck + 1;
                if (Score != null)
                    Score.setText(""+correctans);

                if(fcheck<Questnarray.length)
                {
                    set();
                }
                else
                {
                    marks=correctans;
                    String data= "program";
                    Intent in = new Intent(ProgramQuestions.this,Result.class);
                    in.putExtra("program",data);
                    startActivity(in);
                }
                rgrp_answer.clearCheck();
            }
        });

    }
    public void ids()
    {
        nextbtn=findViewById(R.id.btnnext);
        quest=findViewById(R.id.tv_question);
        leavebtn=findViewById(R.id.btnleave);
        rgrp_answer=findViewById(R.id.rg_options);
        op_1=findViewById(R.id.op1);
        op_4=findViewById(R.id.op4);
        op_2=findViewById(R.id.op2);
        op_3=findViewById(R.id.op3);
    }
    public void setoptions()
    {
        quest.setText(Questnarray[fcheck]);
        op_1.setText(choices_array[0]);
        op_2.setText(choices_array[1]);
        op_3.setText(choices_array[2]);
        op_4.setText(choices_array[3]);
    }
    public void set()
    {
        quest.setText(Questnarray[fcheck]);
        op_1.setText(choices_array[fcheck*4]);
        op_2.setText(choices_array[fcheck*4 +1]);
        op_3.setText(choices_array[fcheck*4 +2]);
        op_4.setText(choices_array[fcheck*4 +3]);
    }



}