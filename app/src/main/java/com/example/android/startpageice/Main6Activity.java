package com.example.android.startpageice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {


    private float mScore1Steps;
    private float mScore2Steps;
    private float mScore1Jumps;
    private float mScore2Jumps;
    private float mScore1Spins;
    private float mScore2Spins;


    private void initScore() {
        Intent i = getIntent();
        mScore1Steps = i.getFloatExtra("com.example.android.startpageice.Steps1Score", 0);
        mScore2Steps = i.getFloatExtra("com.example.android.startpageice.Steps2Score", 0);
        mScore1Jumps = i.getFloatExtra("com.example.android.startpageice.Jumps1Score", 0);
        mScore2Jumps = i.getFloatExtra("com.example.android.startpageice.Jumps2Score", 0);
        mScore1Spins = i.getFloatExtra("com.example.android.startpageice.Spins1Score", 0);
        mScore2Spins = i.getFloatExtra("com.example.android.startpageice.Spins2Score", 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        initScore();
        displayScore();
    }

    void displayScore(){
        TextView jumpsScore1 = (TextView)findViewById(R.id.jumpsTotal1);
        TextView jumpsScore2 = (TextView)findViewById(R.id.jumpsTotal2);
        TextView stepsScore1 = (TextView)findViewById(R.id.stepsTotal1);
        TextView stepsScore2 = (TextView)findViewById(R.id.stepsTotal2);
        TextView spinsScore1 = (TextView)findViewById(R.id.spinsTotal1);
        TextView spinsScore2 = (TextView)findViewById(R.id.spinsTotal2);

        String val;

        val = String.format("%.2f", mScore1Steps);
        stepsScore1.setText(val);

        val = String.format("%.2f", mScore2Steps);
        stepsScore2.setText(val);

        val = String.format("%.2f", mScore1Jumps);
        jumpsScore1.setText(val);

        val = String.format("%.2f", mScore2Jumps);
        jumpsScore2.setText(val);

        val = String.format("%.2f", mScore1Spins);
        spinsScore1.setText(val);

        val = String.format("%.2f", mScore2Spins);
        spinsScore2.setText(val);

    }
}
