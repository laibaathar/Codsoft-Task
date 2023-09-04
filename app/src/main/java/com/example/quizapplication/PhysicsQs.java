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

public class PhysicsQs extends AppCompatActivity {
    int fcheck=0;
    public static int marks=0;
    public static int correctans=0;
    public static int incorrectans=0;
    Button leavebtn,nextbtn;
    RadioButton op_1,op_2,op_3,op_4;
    TextView quest;
    RadioGroup rgrp_answer;
    String ansarray[] = {"Seconds","Friction","Amperes","9.8 m/s²","Blue","Law of inertia","Thermal energy","Alternating Current","Law of Conservation of Energy","300,000,000 meters per second"};

    String choices_array[] = {
            "Seconds","Meters","Kilograms","Joules",
            "Gravity","Friction","Magnetism","Buoyancy",
            "Volts","Watts","Amperes","Ohms",
            "1 m/s²","5 m/s²","9.8 m/s²","12 m/s²",
            "Red","Blue","Green","Yellow",
            "Law of action-reaction","Law of inertia","Law of acceleration","Law of gravitation",
            "Kinetic energy","Potential energy","Thermal energy","Nuclear energy",
            "Alternating Current","Amperes of Charge","Atomic Circuits","Alternating Charge",
            "Newton's First Law","Kepler's Third Law","Law of Conservation of Energy","Boyle's Law",
            "300,000,000 meters per second","100,000 meters per second","3,000 meters per second","30,000,000 meters per second"};
    String Questnarray[] = {"Q: What is the unit of measurement for time?",
            "Q: Which of the following is a force that opposes motion between two surfaces in contact?",
            "Q: What is the SI unit of electric current?",
            "Q: What is the acceleration due to gravity on the surface of Earth (approximately)?",
            "Q: Which color of light has the shortest wavelength in the visible spectrum?",
            "Q: What is the first law of motion, also known as?",
            "Q: Which type of energy is associated with the motion of molecules and atoms?",
            "Q: What does the acronym \"AC\" stand for in electrical circuits?",
            "Q: Which law states that the total energy in a closed system remains constant?",
            "Q: What is the speed of light in a vacuum (approximately)?"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics_qs);

        ids();
        final TextView Score = findViewById(R.id.tvscrnum);
        setoptions();

        leavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(PhysicsQs.this,MainActivity.class);
                startActivity(in);
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rgrp_answer.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(PhysicsQs.this, "select option to proceed", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton temp = (RadioButton) findViewById(rgrp_answer.getCheckedRadioButtonId());
                String store = temp.getText().toString();

                if(store.equals(ansarray[fcheck])) {
                    correctans = correctans + 1;
                    Toast.makeText(PhysicsQs.this, "Correct Answer !!", Toast.LENGTH_SHORT).show();
                }
                else {
                    incorrectans = incorrectans +1;
                    Toast.makeText(PhysicsQs.this, "Incorrect Answer !!", Toast.LENGTH_SHORT).show();
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
                    String data= "phy";
                    Intent in = new Intent(PhysicsQs.this,Result.class);
                    in.putExtra("phy",data);
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