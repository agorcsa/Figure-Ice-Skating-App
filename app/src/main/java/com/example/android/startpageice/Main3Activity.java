package com.example.android.startpageice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner mStepsSqSkater1;
    Spinner mStepsSqSkater2;
    Spinner mCoreoSqSkater1;
    Spinner mCoreoSqSkater2;
    Spinner mGoeStepsSqSkater1;
    Spinner mGoeStepsSqSkater2;
    Spinner mGoeCoreoSqSkater1;
    Spinner mGoeCoreoSqSkater2;
    TextView mScoreStepsSkater1;
    TextView mScoreStepsSkater2;
    float[] mSkaterScores = {0f, 0f};
    private float mScore1Steps;
    private float mScore2Steps;

    private void initStepsScore() {
        Intent i = getIntent();
        mScore1Steps = i.getFloatExtra("com.example.android.startpageice.Steps1Score", 0);
        mScore2Steps = i.getFloatExtra("com.example.android.startpageice.Steps2Score", 0);
        mSkaterScores[0] = i.getFloatExtra("com.example.android.startpageice.Jumps1Score", 0);
        mSkaterScores[1] = i.getFloatExtra("com.example.android.startpageice.Jumps2Score", 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initStepsScore();
        mStepsSqSkater1 = (Spinner) findViewById(R.id.stepsSq1);
        mCoreoSqSkater1 = (Spinner) findViewById(R.id.coreoSq1);
        mStepsSqSkater2 = (Spinner) findViewById(R.id.stepsSq2);
        mCoreoSqSkater2 = (Spinner) findViewById(R.id.coreoSq2);
        mGoeStepsSqSkater1 = (Spinner) findViewById(R.id.goeStepsSq1);
        mGoeCoreoSqSkater1 = (Spinner) findViewById(R.id.goeCoreoSq1);
        mGoeStepsSqSkater2 = (Spinner) findViewById(R.id.goeStepsSq2);
        mGoeCoreoSqSkater2 = (Spinner) findViewById(R.id.goeCoreoSq2);
        mScoreStepsSkater1 = (TextView) findViewById(R.id.scoreStepsSkater1);
        mScoreStepsSkater2 = (TextView) findViewById(R.id.scoreStepsSkater2);
        mStepsSqSkater1.setOnItemSelectedListener(this);
        mStepsSqSkater2.setOnItemSelectedListener(this);
        mCoreoSqSkater1.setOnItemSelectedListener(this);
        mCoreoSqSkater2.setOnItemSelectedListener(this);
        mGoeStepsSqSkater1.setOnItemSelectedListener(this);
        mGoeStepsSqSkater2.setOnItemSelectedListener(this);
        mGoeCoreoSqSkater1.setOnItemSelectedListener(this);
        mGoeCoreoSqSkater2.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        updateScore();
    }

    private void updateScore() {
        String tmp;
        tmp = mStepsSqSkater1.getSelectedItem().toString();
        float stepsSq1 = getStepsSqDeltaScoreFromString(tmp);
        tmp = mCoreoSqSkater1.getSelectedItem().toString();
        float coreoSq1 = getCoreoSqDeltaScoreFromString(tmp);
        tmp = mStepsSqSkater2.getSelectedItem().toString();
        float stepsSq2 = getStepsSqDeltaScoreFromString(tmp);
        tmp = mCoreoSqSkater2.getSelectedItem().toString();
        float coreoSq2 = getCoreoSqDeltaScoreFromString(tmp);
        tmp = mGoeStepsSqSkater1.getSelectedItem().toString();
        float goeStepsSq1 = getGoeStepsSqDeltaScoreFromString(tmp);
        tmp = mGoeCoreoSqSkater1.getSelectedItem().toString();
        float goeCoreoSq1 = getGoeCoreoSqDeltaScoreFromString(tmp);
        tmp = mGoeStepsSqSkater2.getSelectedItem().toString();
        float goeStepsSq2 = getGoeStepsSqDeltaScoreFromString(tmp);
        tmp = mGoeCoreoSqSkater2.getSelectedItem().toString();
        float goeCoreoSq2 = getGoeCoreoSqDeltaScoreFromString(tmp);
        float score1 = (stepsSq1 + goeStepsSq1) + (coreoSq1 + goeCoreoSq1);
        float score2 = (stepsSq2 + goeStepsSq2) + (coreoSq2 + goeCoreoSq2);
        displayForSkater1(score1);
        displayForSkater2(score2);
    }

    private float getDeltaScoreFromStringStepsSq(String str) {
        if (str.equals("0"))
            return 0f;
        if (str.equals("B"))
            return 1.5f;
        if (str.equals("1"))
            return 1.8f;
        if (str.equals("2"))
            return 2.6f;
        if (str.equals("3"))
            return 3.3f;
        if (str.equals("4"))
            return 3.9f;
        return -1f;
    }

    private float getDeltaScoreFromStringCoreo(String str) {
        if (str.equals("0"))
            return 0f;
        if (str.equals("B"))
            return 2f;
        return -1f;
    }

    private float getGenericGoeDeltaScoreFromString(String str) {
        if (str.equals("-3"))
            return -0.9f;
        if (str.equals("-2"))
            return -0.6f;
        if (str.equals("-1"))
            return -0.3f;
        if (str.equals("+1"))
            return 0.5f;
        if (str.equals("+2"))
            return 1f;
        if (str.equals("+3"))
            return 1.5f;
        return 0f;
    }

    private float getStepsSqDeltaScoreFromString(String str) {
        return getDeltaScoreFromStringStepsSq(str);
    }

    private float getCoreoSqDeltaScoreFromString(String str) {
        return getDeltaScoreFromStringCoreo(str);
    }

    private float getGoeStepsSqDeltaScoreFromString(String str) {
        return getGenericGoeDeltaScoreFromString(str);
    }

    private float getGoeCoreoSqDeltaScoreFromString(String str) {
        return getGenericGoeDeltaScoreFromString(str);
    }

    /**
     * The method is empty because there is no action to perform here.
     * In the spinners there will be always something selected.
     * The method is still exists, because it's part of the OnItemSelectedListener.
     */
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void resetScore(View view) {
        mStepsSqSkater1.setSelection(0);
        mStepsSqSkater2.setSelection(0);
        mCoreoSqSkater1.setSelection(0);
        mCoreoSqSkater2.setSelection(0);
        mGoeStepsSqSkater1.setSelection(0);
        mGoeStepsSqSkater2.setSelection(0);
        mGoeCoreoSqSkater1.setSelection(0);
        mGoeCoreoSqSkater2.setSelection(0);
        updateScore();
    }

    public void displayForSkater1(float score1) {
        mSkaterScores[0] = score1;
        String val = String.format("TOTAL: " + "%.2f " + "points", mSkaterScores[0]);
        mScoreStepsSkater1.setText(val);
    }

    public void displayForSkater2(float score2) {
        mSkaterScores[1] = score2;
        String val = String.format("TOTAL: " + "%.2f " + "points", mSkaterScores[1]);
        mScoreStepsSkater2.setText(val);
    }

    public void videoButton1(View view) {
        String video_path = "https://www.youtube.com/watch?v=CrVL5tM926s&t=13s";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(video_path));
        startActivity(intent);
    }

    public void videoButton2(View view) {
        String video_path = "https://www.youtube.com/watch?v=hgXKJvTVW9g&t=36s";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(video_path));
        startActivity(intent);
    }

    public void startSecondActivity(View view) {
        Intent main2Activity = new Intent(this, Main2Activity.class);
        main2Activity.putExtra("com.example.android.startpageice.Steps1Score", mScore1Steps);
        main2Activity.putExtra("com.example.android.startpageice.Steps2Score", mScore2Steps);
        startActivity(main2Activity);
    }

    public void startForthActivity(View view) {
        String name1 = getIntent().getExtras().getString("caca1");
        String name2 = getIntent().getExtras().getString("caca2");

        Intent main4Activity = new Intent(this, Main4Activity.class);
        main4Activity.putExtra("caca1", name1);
        main4Activity.putExtra("caca2", name2);
        main4Activity.putExtra("com.example.android.startpageice.Steps1Score", mScore1Steps);
        main4Activity.putExtra("com.example.android.startpageice.Steps2Score", mScore2Steps);
        main4Activity.putExtra("com.example.android.startpageice.Jumps1Score", mSkaterScores[0]);
        main4Activity.putExtra("com.example.android.startpageice.Jumps2Score", mSkaterScores[1]);
        Log.d("andre", "starting 4");
        startActivity(main4Activity);
    }
}