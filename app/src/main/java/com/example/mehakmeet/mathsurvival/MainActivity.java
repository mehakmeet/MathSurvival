package com.example.mehakmeet.mathsurvival;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button easy;
    Button medium;
    Button hard;
    EditText time_value;
    int get_difficulty;
    public static String Extra3="bro";
    public static String Extra4="dude";


    public void difficulty(View view){
        Button butt = (Button) view;
        get_difficulty= Integer.parseInt(butt.getTag().toString());
        System.out.println(get_difficulty);
        Intent i1=new Intent(MainActivity.this,Main_Math_probs.class);
        i1.putExtra(Extra3,String.valueOf(get_difficulty));
        i1.putExtra(Extra4,String.valueOf(time_value));

        startActivity(i1);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easy = (Button)findViewById(R.id.easybutton);
        medium = (Button)findViewById(R.id.mediumbutton);
        hard = (Button) findViewById(R.id.hardbutton);
        time_value=(EditText) findViewById(R.id.timer_value);
    }
}
