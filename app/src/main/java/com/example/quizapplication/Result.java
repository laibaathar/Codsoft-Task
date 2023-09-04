package com.example.quizapplication;

import android.widget.TextView;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    TextView tv_correct1;
    TextView tv_incorrect1;
    TextView tv_total1;
    TextView remark;
    Button homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_correct1 = findViewById(R.id.tv_incorectans);
        tv_incorrect1 = findViewById(R.id.tv_correctans);
        tv_total1 = findViewById(R.id.tv_total);
        remark= findViewById(R.id.remarks);
        homebtn = findViewById(R.id.btnhome);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Result.this, MainActivity.class);
                startActivity(in);
            }
        });

        Intent inn = getIntent();
        String dataa = inn.getStringExtra("startrandom");
        if (dataa != null && dataa.equals("startrandom")) {

            int correct = StartRandom.correctans ;
            int incorrect= StartRandom.incorrectans;
            StringBuffer a = new StringBuffer();
            a.append("Correct answers: " + correct + "\n");
            StringBuffer a1 = new StringBuffer();
            a1.append("Incorrect Answers: " + incorrect + "\n");
            StringBuffer a2 = new StringBuffer();
            a2.append("Total Score: " + correct+" / 10" + "\n");
            tv_correct1.setText(a);
            tv_incorrect1.setText(a1);
            tv_total1.setText(a2);

            if(correct >= 5 && correct < 10)
            {
                String emoji1 = "\uD83D\uDC4F";
                String str1 = "!!! "+emoji1+" You Pass "+emoji1+ " !!!";
                remark.setText(str1);

            } else if (correct == 10 ) {
                String emoji2 = "\uD83C\uDF89";
                String str2 = "!!! "+emoji2+" congratulations "+emoji2+ " !!!";
                remark.setText(str2);

            } else if (correct <5 && correct >2) {

                String emoji3 = "\uD83D\uDC4E";
                String str3 = "!!! "+emoji3+" Try Again "+emoji3+ " !!!";
                remark.setText(str3);
            } else  {
                String emoji4 = "\uD83D\uDE1E";
                String str4 = "!!! "+emoji4+" You Fail "+emoji4+ " !!!";
                remark.setText(str4);
            }
            StartRandom.correctans = 0;
            StartRandom.incorrectans = 0;
        }

        Intent i = getIntent();
        String progrm = i.getStringExtra("program");
        if (progrm != null && progrm.equals("program")) {

            int correct2 = ProgramQuestions.correctans;
            int incorrect2 = ProgramQuestions.incorrectans;
            StringBuffer pr = new StringBuffer();
            pr.append("Correct answers: " + correct2 + "\n");
            StringBuffer pr2 = new StringBuffer();
            pr2.append("Incorrect Answers: " + incorrect2 + "\n");
            StringBuffer pr3 = new StringBuffer();
            pr3.append("Total Score: " + correct2+" / 10" + "\n");
            TextView programTv1 = findViewById(R.id.tv_incorectans);
            TextView programTv2 = findViewById(R.id.tv_correctans);
            TextView programTv3 = findViewById(R.id.tv_total);
            programTv1.setText(pr);
            programTv2.setText(pr2);
            programTv3.setText(pr3);

            if(correct2 >= 5 && correct2 < 10)
            {
                String emoji5 = "\uD83D\uDC4F";
                String str5 = "!!! "+emoji5+" You Pass "+emoji5+ " !!!";
                remark.setText(str5);

            } else if (correct2 == 10 ) {
                String emoji6 = "\uD83C\uDF89";
                String str6 = "!!! "+emoji6+" congratulations "+emoji6+ " !!!";
                remark.setText(str6);

            } else if (correct2 <5 && correct2 >2) {

                String emoji7 = "\uD83D\uDC4E";
                String str7 = "!!! "+emoji7+" Try Again "+emoji7+ " !!!";
                remark.setText(str7);
            } else  {
                String emoji8 = "\uD83D\uDE1E";
                String str8 = "!!! "+emoji8+" You Fail "+emoji8+ " !!!";
                remark.setText(str8);
            }
            ProgramQuestions.correctans = 0;
            ProgramQuestions.incorrectans = 0;
        }


        Intent obj1 = getIntent();
        String chem = obj1.getStringExtra("chem");
        if (chem  != null && chem.equals("chem")) {

            int correct3 = ChemistryQs.correctans;
            int incorrect3 = ChemistryQs.incorrectans;
            StringBuffer ch = new StringBuffer();
            ch.append("Correct answers: " + correct3 + "\n");
            StringBuffer ch2 = new StringBuffer();
            ch2.append("Incorrect Answers: " + incorrect3 + "\n");
            StringBuffer ch3 = new StringBuffer();
            ch3.append("Total Score: " + correct3+" / 10" + "\n");
            TextView chemTv = findViewById(R.id.tv_incorectans);
            TextView chemTv2 = findViewById(R.id.tv_correctans);
            TextView chemTv3 = findViewById(R.id.tv_total);
            chemTv.setText(ch);
            chemTv2.setText(ch2);
            chemTv3.setText(ch3);

            if(correct3 >= 5 && correct3 < 10)
            {
                String emoji9 = "\uD83D\uDC4F";
                String str9 = "!!! "+emoji9+" You Pass "+emoji9+ " !!!";
                remark.setText(str9);

            } else if (correct3 == 10 ) {
                String emoji10 = "\uD83C\uDF89";
                String str10 = "!!! "+emoji10+" congratulations "+emoji10+ " !!!";
                remark.setText(str10);

            } else if (correct3 <5 && correct3 >2) {

                String emoji11 = "\uD83D\uDC4E";
                String str11 = "!!! "+emoji11+" Try Again "+emoji11+ " !!!";
                remark.setText(str11);
            } else  {
                String emoji12 = "\uD83D\uDE1E";
                String str12 = "!!! "+emoji12+" You Fail "+emoji12+ " !!!";
                remark.setText(str12);
            }
            ChemistryQs.correctans = 0;
            ChemistryQs.incorrectans = 0;
        }

        Intent obj2 = getIntent();
        String math = obj2.getStringExtra("math");
        if (math != null && math.equals("math")) {

            int correct4 = MathsQs.correctans;
            int incorrect4= MathsQs.incorrectans;
            StringBuffer m = new StringBuffer();
            m.append("Correct answers: " + correct4 + "\n");
            StringBuffer m2 = new StringBuffer();
            m2.append("Incorrect Answers: " + incorrect4 + "\n");
            StringBuffer m3 = new StringBuffer();
            m3.append("Total Score: " + correct4+" / 10" + "\n");
            TextView mathTv1 = findViewById(R.id.tv_incorectans);
            TextView mathTv2 = findViewById(R.id.tv_correctans);
            TextView mathTv3 = findViewById(R.id.tv_total);
            mathTv1.setText(m);
            mathTv2.setText(m2);
            mathTv3.setText(m3);

            if(correct4 >= 5 && correct4 < 10)
            {
                String emoji13 = "\uD83D\uDC4F";
                String str13 = "!!! "+emoji13+" You Pass "+emoji13+ " !!!";
                remark.setText(str13);

            } else if (correct4 == 10 ) {
                String emoji14 = "\uD83C\uDF89";
                String str14 = "!!! "+emoji14+" congratulations "+emoji14+ " !!!";
                remark.setText(str14);

            } else if (correct4 <5 && correct4 >2) {

                String emoji15 = "\uD83D\uDC4E";
                String str15 = "!!! "+emoji15+" Try Again "+emoji15+ " !!!";
                remark.setText(str15);
            } else  {
                String emoji16 = "\uD83D\uDE1E";
                String str16 = "!!! "+emoji16+" You Fail "+emoji16+ " !!!";
                remark.setText(str16);
            }
            MathsQs.correctans = 0;
            MathsQs.incorrectans = 0;
        }

        Intent obj3 = getIntent();
        String phy = obj3.getStringExtra("phy");
        if (phy != null && phy.equals("phy")) {

            int correct5 = PhysicsQs.correctans;
            int incorrect5= PhysicsQs.incorrectans;
            StringBuffer physc = new StringBuffer();
            physc.append("Correct answers: " + correct5 + "\n");
            StringBuffer physc2 = new StringBuffer();
            physc2.append("Incorrect Answers: " + incorrect5 + "\n");
            StringBuffer physc3 = new StringBuffer();
            physc3.append("Total Score: " + correct5+" / 10" + "\n");
            TextView phyTv = findViewById(R.id.tv_incorectans);
            TextView phyTv2 = findViewById(R.id.tv_correctans);
            TextView phyTv3 = findViewById(R.id.tv_total);
            phyTv.setText(physc);
            phyTv2.setText(physc2);
            phyTv3.setText(physc3);

            if(correct5 >= 5 && correct5 < 10)
            {
                String emoji17 = "\uD83D\uDC4F";
                String str17 = "!!! "+emoji17+" You Pass "+emoji17+ " !!!";
                remark.setText(str17);

            } else if (correct5 == 10 ) {
                String emoji18 = "\uD83C\uDF89";
                String str18 = "!!! "+emoji18+" congratulations "+emoji18+ " !!!";
                remark.setText(str18);

            } else if (correct5 <5 && correct5 >2) {

                String emoji19 = "\uD83D\uDC4E";
                String str19 = "!!! "+emoji19+" Try Again "+emoji19+ " !!!";
                remark.setText(str19);
            } else  {
                String emoji20 = "\uD83D\uDE1E";
                String str20 = "!!! "+emoji20+" You Fail "+emoji20+ " !!!";
                remark.setText(str20);
            }

            PhysicsQs.correctans = 0;
            PhysicsQs.incorrectans = 0;
        }

    }
}
