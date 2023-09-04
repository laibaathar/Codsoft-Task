package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Selecttype extends AppCompatActivity {

    CardView programming, chem, phy, math;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecttype);

        programming = findViewById(R.id.c_program);
        chem= findViewById(R.id.c_chemistry);
        phy = findViewById(R.id.c_physics);
        math =findViewById(R.id.c_math);

        programming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Selecttype.this,ProgramQuestions.class);
                startActivity(i);
            }
        });

        chem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Selecttype.this,ChemistryQs.class);
                startActivity(i);
            }
        });
        phy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Selecttype.this,PhysicsQs.class);
                startActivity(i);
            }
        });
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Selecttype.this,MathsQs.class);
                startActivity(i);
            }
        });
    }
}