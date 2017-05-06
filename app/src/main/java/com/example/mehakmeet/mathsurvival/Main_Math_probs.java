package com.example.mehakmeet.mathsurvival;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class Main_Math_probs extends AppCompatActivity {

    TextView timer;
    TextView score;
    TextView problem;
    TextView option1;
    TextView option2;
    TextView option3;
    TextView option4;
    TextView RightorWrong;
    int score_count = 0;
    int no_of_quest = 0;
    Random answer = new Random();
    int ansTag ;
    int n1,n2,op1,op2,op3,ans;

    public static String Extra1="abc";
    public static String Extra2="veg";

    public void clicked(View view) {
        TextView userans = (TextView) view;
        int clickTag = Integer.parseInt(userans.getTag().toString());
        RightorWrong = (TextView) findViewById(R.id.RightOrWrong);
        if (clickTag == ansTag) {
            RightorWrong.animate().alpha(1f);
            RightorWrong.setText("Correct!");
            score_count++;
            no_of_quest++;
            score.setText(String.valueOf(score_count) + "/" + String.valueOf(no_of_quest));
            update_quest();
        } else {
            RightorWrong.animate().alpha(1f);
            RightorWrong.setText("Wrong!");
            no_of_quest++;
            score.setText(String.valueOf(score_count) + "/" + String.valueOf(no_of_quest));
            update_quest();
        }
    }


    public void update_quest() {
        Random random = new Random();
        ansTag = answer.nextInt(4)+1;

        Intent i2=getIntent();
        String difficult = i2.getStringExtra(MainActivity.Extra3);
        int difficulty = Integer.parseInt(difficult);
        if(difficulty==1){

            n1 = random.nextInt(10) + 1;
            n2 = random.nextInt(10) + 1;
            op1 = random.nextInt(20) + 2;
            op2 = random.nextInt(20) + 2;
            op3 = random.nextInt(20) + 2;
            ans = n1 + n2;
        }
        if(difficulty==2){

            n1 = random.nextInt(10) + 21;
            n2 = random.nextInt(10) + 21;
            op1 = random.nextInt(60) + 2;
            op2 = random.nextInt(60) + 2;
            op3 = random.nextInt(60) + 2;
            ans = n1 + n2;
        }
        if(difficulty==3){

            n1 = random.nextInt(10) + 81;
            n2 = random.nextInt(10) + 81;
            op1 = random.nextInt(180) + 2;
            op2 = random.nextInt(180) + 2;
            op3 = random.nextInt(180) + 2;
            ans = n1 + n2;
        }

        problem.setText(String.valueOf(n1) + " + " + String.valueOf(n2));
        if (ansTag == 1) {
            option1.setText(String.valueOf(ans));
            option2.setText(String.valueOf(op1));
            option3.setText(String.valueOf(op2));
            option4.setText(String.valueOf(op3));
        }
        if (ansTag == 2) {
            option2.setText(String.valueOf(ans));
            option1.setText(String.valueOf(op1));
            option3.setText(String.valueOf(op2));
            option4.setText(String.valueOf(op3));
        }
        if (ansTag == 3) {
            option3.setText(String.valueOf(ans));
            option2.setText(String.valueOf(op1));
            option1.setText(String.valueOf(op2));
            option4.setText(String.valueOf(op3));
        }
        if (ansTag == 4) {
            option4.setText(String.valueOf(ans));
            option2.setText(String.valueOf(op1));
            option3.setText(String.valueOf(op2));
            option1.setText(String.valueOf(op3));
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__math_probs);


        timer = (TextView) findViewById(R.id.timer);
        score = (TextView) findViewById(R.id.score);
        problem = (TextView) findViewById(R.id.problem);
        option1 = (TextView) findViewById(R.id.option1);
        option2 = (TextView) findViewById(R.id.option2);
        option3 = (TextView) findViewById(R.id.option3);
        option4 = (TextView) findViewById(R.id.option4);
        RightorWrong = (TextView) findViewById(R.id.RightOrWrong);
        update_quest();


        new CountDownTimer(30*1000+100,1000){

            @Override
            public void onTick(long millisUntilFinished) {

                timer.setText(String.valueOf(millisUntilFinished/1000)+"s");

            }

            @Override
            public void onFinish() {
                timer.setText("0s");
                Intent i =new Intent(Main_Math_probs.this,Result_screen.class);
                i.putExtra(Extra1,String.valueOf(no_of_quest));
                i.putExtra(Extra2,String.valueOf(score_count));
                startActivity(i);
            }
        }.start();


    }
}

