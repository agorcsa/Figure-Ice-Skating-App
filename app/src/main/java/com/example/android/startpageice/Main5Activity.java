package com.example.android.startpageice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.startpageice.R.id.stepsTotal2;

public class Main5Activity extends AppCompatActivity {
    private float mScore1Jumps;
    private float mScore2Jumps;
    private float mScore1Steps;
    private float mScore2Steps;
    private float mScore1Spins;
    private float mScore2Spins;
    private float mTotalScore1;
    private float mTotalScore2;
    private String mName1;
    private String mName2;

    private void initScore() {
        Intent i = getIntent();
        mScore1Jumps = i.getFloatExtra("com.example.android.startpageice.Jumps1Score", 0);
        mScore2Jumps = i.getFloatExtra("com.example.android.startpageice.Jumps2Score", 0);
        mScore1Steps = i.getFloatExtra("com.example.android.startpageice.Steps1Score", 0);
        mScore2Steps = i.getFloatExtra("com.example.android.startpageice.Steps2Score", 0);
        mScore1Spins = i.getFloatExtra("com.example.android.startpageice.Spins1Score", 0);
        mScore2Spins = i.getFloatExtra("com.example.android.startpageice.Spins2Score", 0);
        mName1 = i.getStringExtra("text1");
        mName2 = i.getStringExtra("text2");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        initScore();
        displayScore();
    }

    void displayScore(){
        TextView jumpsScore1 = (TextView)findViewById(R.id.jumpsTotal1);
        TextView jumpsScore2 = (TextView)findViewById(R.id.jumpsTotal2);
        TextView stepsScore1 = (TextView)findViewById(R.id.stepsTotal1);
        TextView stepsScore2 = (TextView) findViewById(stepsTotal2);
        TextView spinsScore1 = (TextView)findViewById(R.id.spinsTotal1);
        TextView spinsScore2 = (TextView)findViewById(R.id.spinsTotal2);
        TextView scoreFinalSkater1 = (TextView) findViewById(R.id.scoreFinalSkater1);
        TextView scoreFinalSkater2 = (TextView) findViewById(R.id.scoreFinalSkater2);
        mTotalScore1 = mScore1Jumps + mScore1Steps + mScore1Spins;
        mTotalScore2 = mScore2Jumps + mScore2Steps + mScore2Spins;
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
        val = String.format("TOTAL: " + "%.2f " + "points", mTotalScore1);
        scoreFinalSkater1.setText(val);
        val = String.format("TOTAL: " + "%.2f " + "points", mTotalScore2);
        scoreFinalSkater2.setText(val);
        if ((mTotalScore1) > (mTotalScore2)) {
            Toast.makeText(getApplicationContext(), "The winner is skater: " + mName1, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "The winner is skater: " + mName2, Toast.LENGTH_LONG).show();
            return;
        }
    }
}
