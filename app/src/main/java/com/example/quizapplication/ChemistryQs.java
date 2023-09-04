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

public class ChemistryQs extends AppCompatActivity {
    int fcheck=0;
    public static int marks=0;
    public static int correctans=0;
    public static int incorrectans=0;
    Button leavebtn,nextbtn;
    RadioButton op_1,op_2,op_3,op_4;
    TextView quest;
    RadioGroup rgrp_answer;
    String ansarray[] = {"O","Helium","H2O","Nitrogen","6","Fluorine","Sublimation","NaCl","Carbon dioxide","7"};
    String choices_array[] = {
            "O","Ox","Oz","Oxg",
            "Oxygen","Hydrogen","Helium","Nitrogen",
            "H2O","CO2","CH4","NH3",
            "Oxygen","Carbon dioxide","Nitrogen","Hydrogen",
            "12","6","14","8",
            "Sodium","Fluorine","Calcium","Potassium",
            "Evaporation","Condensation","Sublimation","Fusion",
            "NaOH","Na2CO3","NaCl","Na2SO4",
            "Oxygen","Carbon monoxide","Carbon dioxide","Methane",
            "0","7","14","1"
    };
    String Questnarray[] = {
            "Q: What is the chemical symbol for oxygen?", "Q: Which of the following is a noble gas?",
            "Q: What is the chemical formula of water?", "Q: Which gas makes up the majority of Earth's atmosphere?",
            "Q: What is the atomic number of carbon?", "Q: Which of the following is a halogen?",
            "Q: What is the process by which a solid changes directly into a gas without passing through the liquid state called?",
            "Q: What is the chemical formula for sodium chloride (table salt)?", "Q: Which gas is responsible for the greenhouse effect on Earth?",
            "Q: What is the pH value of a neutral solution?"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry_qs);

        ids();
        final TextView Score = findViewById(R.id.tvscrnum);
        setoptions();

        leavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ChemistryQs.this,MainActivity.class);
                startActivity(in);
            }
        });
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rgrp_answer.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(ChemistryQs.this, "select option to proceed", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton temp = (RadioButton) findViewById(rgrp_answer.getCheckedRadioButtonId());
                String store = temp.getText().toString();

                if(store.equals(ansarray[fcheck])) {
                    correctans = correctans + 1;
                    Toast.makeText(ChemistryQs.this, "Correct Answer !!", Toast.LENGTH_SHORT).show();
                }
                else {
                    incorrectans = incorrectans +1;
                    Toast.makeText(ChemistryQs.this, "Incorrect Answer !!", Toast.LENGTH_SHORT).show();
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
                    String chem= "chem";
                    Intent in = new Intent(ChemistryQs.this,Result.class);
                    in.putExtra("chem",chem);
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