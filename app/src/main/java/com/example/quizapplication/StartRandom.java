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

public class StartRandom extends AppCompatActivity {
    int fcheck=0;
    public static int marks=0;
    public static int correctans=0;
    public static int incorrectans=0;
    Button leavebtn,nextbtn;
    RadioButton op_1,op_2,op_3,op_4;
    TextView quest;
    RadioGroup rgrp_answer;
    String ansarray[] = {
            "Ancient Egyptians","George Washington","Europe",
            "The assassination of Archduke Franz Ferdinand",
            "William Shakespeare","Ancient India","United Kingdom",
            "Nikita Khrushchev","Rule of Law","Mayflower"
    };
    String choices_array[] = {
            "Roman Empire","Greek Civilization","Ancient Egyptians","Mesopotamians",
            "Abraham Lincoln","Thomas Jefferson","George Washington","Benjamin Franklin",
            "Asia","Africa","Europe","South America",
            "The bombing of Hiroshima","The signing of the Treaty of Versailles","The assassination of Archduke Franz Ferdinand","The sinking of the Titanic",
            "William Shakespeare","Geoffrey Chaucer","Homer","Mark Twain",
            "Ancient Egypt","Ancient Greece","Ancient China","Ancient India",
            "France","United Kingdom","Germany"," United States",
            "Joseph Stalin","Vladimir Putin","Mikhail Gorbachev","Nikita Khrushchev",
            "Freedom of Speech","Democracy","Rule of Law","Religious Freedom",
            "Mayflower","Santa Maria"," HMS Endeavour","Titanic"};
    String Questnarray[] = { "Q: Which ancient civilization built the Great Pyramid of Giza?", "Q: Who was the first President of the United States?",
            "Q: The Renaissance was a period of cultural and artistic rebirth in which part of the world?", "Q: What event marked the beginning of World War I?",
            "Q: Who wrote the play \"Romeo and Juliet\"? ", "Q: Which ancient civilization is known for its contributions to mathematics, including the concept of zero?", "Q: The Industrial Revolution began in which country?", "Q: Who was the leader of the Soviet Union during the Cuban Missile Crisis?",
            "Q: The Magna Carta, signed in 1215, was a pivotal document that influenced the development of which principle?", "Q: What was the name of the ship that carried the Pilgrims to America in 1620?"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_random);

        ids();
        final TextView Score = findViewById(R.id.tvscrnum);
        setoptions();

        leavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(StartRandom.this,MainActivity.class);
                startActivity(in);
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rgrp_answer.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(StartRandom.this, "select option to proceed", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton temp = (RadioButton) findViewById(rgrp_answer.getCheckedRadioButtonId());
                String store = temp.getText().toString();

                if(store.equals(ansarray[fcheck])) {
                    correctans = correctans + 1;
                    Toast.makeText(StartRandom.this, "Correct Answer !!", Toast.LENGTH_SHORT).show();
                }
                else {
                    incorrectans = incorrectans +1;
                    Toast.makeText(StartRandom.this, "Incorrect Answer !!", Toast.LENGTH_SHORT).show();
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
                    String data1= "startrandom";
                    Intent in = new Intent(getApplicationContext(),Result.class);
                    in.putExtra("startrandom",data1);
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