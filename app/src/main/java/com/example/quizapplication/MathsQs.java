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

public class MathsQs extends AppCompatActivity {
    int fcheck=0;
    public static int marks=0;
    public static int correctans=0;
    public static int incorrectans=0;
    Button leavebtn,nextbtn;
    RadioButton op_1,op_2,op_3,op_4;
    TextView quest;
    RadioGroup rgrp_answer;
    String ansarray[] = {"11","8","3.14","24 square units","2","10","10","36","45","Equilateral"};
    String choices_array[] = {
            "10","11","12","14",
            "2","5","8","15",
            "2.71","3.14","3.21","4.23",
            "10 square units","12 square units","18 square units","24 square units",
            "2","4","8","16",
            "10","14","21","73",
            "10","12","16","20",
            "12","24","36","48",
            "14","36","45","54",
            "Scalene","Isosceles","Equilateral","Right-angled"};
    String Questnarray[] = {
            "Q: What is the result of 4 + 7?",
            "Q: If you have 3 apples and you buy 5 more, how many apples do you have in total?",
            "Q: What is the value of π (pi) approximately?",
            "Q: If a rectangle has a length of 6 units and a width of 4 units, what is its area?",
            "Q: What is the square root of 16?",
            "Q: If x = 7 and y = 3, what is the value of x + y?",
            "Q: What is the next number in the sequence: 2, 4, 6, 8, __?",
            "Q: If a dozen cookies contain 12 cookies, how many cookies are there in 3 dozen?",
            "Q: What is the product of 9 and 5?",
            "Q: If a triangle has three sides of equal length, what type of triangle is it?"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_qs);

        ids();
        final TextView Score = findViewById(R.id.tvscrnum);
        setoptions();

        leavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MathsQs.this,MainActivity.class);
                startActivity(in);
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rgrp_answer.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(MathsQs.this, "select option to proceed", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton temp = (RadioButton) findViewById(rgrp_answer.getCheckedRadioButtonId());
                String store = temp.getText().toString();

                if(store.equals(ansarray[fcheck])) {
                    correctans = correctans + 1;
                    Toast.makeText(MathsQs.this, "Correct Answer !!", Toast.LENGTH_SHORT).show();
                }
                else {
                    incorrectans = incorrectans +1;
                    Toast.makeText(MathsQs.this, "Incorrect Answer !!", Toast.LENGTH_SHORT).show();
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
                    String data= "math";
                    Intent in = new Intent(MathsQs.this,Result.class);
                    in.putExtra("math",data);
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