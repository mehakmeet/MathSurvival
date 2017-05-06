package com.example.mehakmeet.mathsurvival;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Result_screen extends AppCompatActivity {

    ImageView less50;
    ImageView betw50to90;
    ImageView above90;
    TextView result;

    public void playAgain(View view){

        Intent i = new Intent(Result_screen.this,MainActivity.class);
        startActivity(i);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        result = (TextView)findViewById(R.id.result);
        less50=(ImageView)findViewById(R.id.lessthan50);
        betw50to90=(ImageView)findViewById(R.id.betw50to90);
        above90=(ImageView)findViewById(R.id.above90);

        Intent i = getIntent();
        String no_of_quest=i.getStringExtra(Main_Math_probs.Extra1);
        String correct_ans=i.getStringExtra(Main_Math_probs.Extra2);
        int quest=Integer.parseInt(no_of_quest);
        int cor_ans=Integer.parseInt(correct_ans);

        float perc= (float)cor_ans/quest * 100;
        if(quest==0){
            result.setText("Next time try to answer atleast one question");
        }
        if(perc<=50 && quest!=0){
            less50.animate().alpha(1f);

            String reperc=String.format("%.2f",(double)perc);
            result.setText(reperc+"% Correct Answers");

        }
        if(50<perc && perc<90){
            betw50to90.animate().alpha(1f);

            String reperc=String.format("%.2f",(double)perc);
            result.setText(reperc+"% Correct Answers");
        }
        if(perc>=90){
            above90.animate().alpha(1f);
            String reperc=String.format("%.2f",(double)perc);
            result.setText(reperc+"% Correct Answers");
        }

    }
}
