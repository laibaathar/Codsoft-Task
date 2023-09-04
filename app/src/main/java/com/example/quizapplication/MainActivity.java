package com.example.quizapplication;

import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button Select, startrandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Select = findViewById(R.id.btnselect);
        startrandom=findViewById(R.id.btn);

        startrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,StartRandom.class);
                startActivity(in);
            }
        });

        Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , Selecttype.class);
                startActivity(i);
            }
        });



    }
}
