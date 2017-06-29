package com.example.android.startpageice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import static com.example.android.startpageice.R.id.scoreSkater1;
import static com.example.android.startpageice.R.id.scoreSkater2;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    /**
     * Declaration of the 24 Spinners: 6 Spinners for "Difficulty" and 6 Spinners for the
     * "Grade of Execution" for each ice skater.
     * Declaration of the 2 TextViews, in which the score for each ice skater will be
     * shown.
     * Declaration of the starting scores (default scores) - > mSkaterScores
     */
    Spinner mToeLoopSkater1;
    Spinner mToeLoopSkater2;
    Spinner mSalchowSkater1;
    Spinner mSalchowTSkater2;
    Spinner mLoopSkater1;
    Spinner mLoopSkater2;
    Spinner mFlipSkater1;
    Spinner mFlipSkater2;
    Spinner mLutzSkater1;
    Spinner mLutzSkater2;
    Spinner mAxelSkater1;
    Spinner mAxelSkater2;
    Spinner mGoeToeLoopSkater1;
    Spinner mGoeToeLoopSkater2;
    Spinner mGoeSalchowSkater1;
    Spinner mGoeSalchowSkater2;
    Spinner mGoeLoopSkater1;
    Spinner mGoeLoopSkater2;
    Spinner mGoeFlipSkater1;
    Spinner mGoeFlipSkater2;
    Spinner mGoeLutzSkater1;
    Spinner mGoeLutzSkater2;
    Spinner mGoeAxelSkater1;
    Spinner mGoeAxelSkater2;
    TextView mScoreJumpsSkater1;
    TextView mScoreJumpsSkater2;
    float[] mSkaterScores = {0f, 0f};

    private void initScore() {
        Intent i = getIntent();
        // when we go back from Main3Activity we have those values set:
        mSkaterScores[0] = i.getFloatExtra("com.example.android.startpageice.Steps1Score", 0);
        mSkaterScores[1] = i.getFloatExtra("com.example.android.startpageice.Steps2Score", 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initScore();
        /**We search after the 24 spinners and the 2 TextViews (mScoreTeam1 and
         mScoreTeam2)
         * in the activity_main2.xml (user interface) and identify them after their id.
         * (actually, we link the class members of the "Main2Activity" from the Java code
         with the Spinner buttons from the activity_main2.xml).
         */
        mToeLoopSkater1 = (Spinner) findViewById(R.id.toeloop1);
        mSalchowSkater1 = (Spinner) findViewById(R.id.salchow1);
        mLoopSkater1 = (Spinner) findViewById(R.id.loop1);
        mFlipSkater1 = (Spinner) findViewById(R.id.flip1);
        mLutzSkater1 = (Spinner) findViewById(R.id.lutz1);
        mAxelSkater1 = (Spinner) findViewById(R.id.axel1);
        mToeLoopSkater2 = (Spinner) findViewById(R.id.toeloop2);
        mSalchowTSkater2 = (Spinner) findViewById(R.id.salchow2);
        mLoopSkater2 = (Spinner) findViewById(R.id.loop2);
        mFlipSkater2 = (Spinner) findViewById(R.id.flip2);
        mLutzSkater2 = (Spinner) findViewById(R.id.lutz2);
        mAxelSkater2 = (Spinner) findViewById(R.id.axel2);
        mGoeToeLoopSkater1 = (Spinner) findViewById(R.id.goeToeloop1);
        mGoeSalchowSkater1 = (Spinner) findViewById(R.id.goeSalchow1);
        mGoeLoopSkater1 = (Spinner) findViewById(R.id.goeLoop1);
        mGoeFlipSkater1 = (Spinner) findViewById(R.id.goeFlip1);
        mGoeLutzSkater1 = (Spinner) findViewById(R.id.goeLutz1);
        mGoeAxelSkater1 = (Spinner) findViewById(R.id.goeAxel1);
        mGoeToeLoopSkater2 = (Spinner) findViewById(R.id.goeToeloop2);
        mGoeSalchowSkater2 = (Spinner) findViewById(R.id.goeSalchow2);
        mGoeLoopSkater2 = (Spinner) findViewById(R.id.goeLoop2);
        mGoeFlipSkater2 = (Spinner) findViewById(R.id.goeFlip2);
        mGoeLutzSkater2 = (Spinner) findViewById(R.id.goeLutz2);
        mGoeAxelSkater2 = (Spinner) findViewById(R.id.goeAxel2);
        mScoreJumpsSkater1 = (TextView) findViewById(scoreSkater1);
        mScoreJumpsSkater2 = (TextView) findViewById(scoreSkater2);
        /**We want to be notified when the items are changing.
         * In this case, "onItemSelected" and "onNothingSelected" will be called*/
        mToeLoopSkater1.setOnItemSelectedListener(this);
        mToeLoopSkater2.setOnItemSelectedListener(this);
        mSalchowSkater1.setOnItemSelectedListener(this);
        mSalchowTSkater2.setOnItemSelectedListener(this);
        mLoopSkater1.setOnItemSelectedListener(this);
        mLoopSkater2.setOnItemSelectedListener(this);
        mFlipSkater1.setOnItemSelectedListener(this);
        mFlipSkater2.setOnItemSelectedListener(this);
        mLutzSkater1.setOnItemSelectedListener(this);
        mLutzSkater2.setOnItemSelectedListener(this);
        mAxelSkater1.setOnItemSelectedListener(this);
        mAxelSkater2.setOnItemSelectedListener(this);
        mGoeToeLoopSkater1.setOnItemSelectedListener(this);
        mGoeToeLoopSkater2.setOnItemSelectedListener(this);
        mGoeSalchowSkater1.setOnItemSelectedListener(this);
        mGoeSalchowSkater2.setOnItemSelectedListener(this);
        mGoeLoopSkater1.setOnItemSelectedListener(this);
        mGoeLoopSkater2.setOnItemSelectedListener(this);
        mGoeFlipSkater1.setOnItemSelectedListener(this);
        mGoeFlipSkater2.setOnItemSelectedListener(this);
        mGoeLutzSkater1.setOnItemSelectedListener(this);
        mGoeLutzSkater2.setOnItemSelectedListener(this);
        mGoeAxelSkater1.setOnItemSelectedListener(this);
        mGoeAxelSkater2.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        updateScore();
    }

    /**
     * Reads all items from the user interface and recalculates the score.
     */
    private void updateScore() {
        String tmp;
        /**
         * Reads the items from the "Difficulty" Spinners for Ice Skater 1.
         */
        tmp = mToeLoopSkater1.getSelectedItem().toString();
        float toeLoop1 = getToeLoopDeltaScoreFromString(tmp);
        tmp = mSalchowSkater1.getSelectedItem().toString();
        float salchow1 = getSalchowDeltaScoreFromString(tmp);
        tmp = mLoopSkater1.getSelectedItem().toString();
        float loop1 = getLoopDeltaScoreFromString(tmp);
        tmp = mFlipSkater1.getSelectedItem().toString();
        float flip1 = getFlipScoreFromString(tmp);
        tmp = mLutzSkater1.getSelectedItem().toString();
        float lutz1 = getLutzScoreFromString(tmp);
        tmp = mAxelSkater1.getSelectedItem().toString();
        float axel1 = getAxelScoreFromFromString(tmp);
        /**
         * Reads the items from the "Difficulty" Spinners for Ice Skater 2.
         */
        tmp = mToeLoopSkater2.getSelectedItem().toString();
        float toeLoop2 = getToeLoopDeltaScoreFromString(tmp);
        tmp = mSalchowTSkater2.getSelectedItem().toString();
        float salchow2 = getSalchowDeltaScoreFromString(tmp);
        tmp = mLoopSkater2.getSelectedItem().toString();
        float loop2 = getLoopDeltaScoreFromString(tmp);
        tmp = mFlipSkater2.getSelectedItem().toString();
        float flip2 = getFlipScoreFromString(tmp);
        tmp = mLutzSkater2.getSelectedItem().toString();
        float lutz2 = getLutzScoreFromString(tmp);
        tmp = mAxelSkater2.getSelectedItem().toString();
        float axel2 = getAxelScoreFromFromString(tmp);
        /**
         * Reads the items from the "GOE" Spinners for Ice Skater 1.
         */
        tmp = mGoeToeLoopSkater1.getSelectedItem().toString();
        float goeToeLoop1 = getGoeToeLoopDeltaScoreFromString(tmp);
        tmp = mGoeSalchowSkater1.getSelectedItem().toString();
        float goeSalchow1 = getGoeSalchowDeltaScoreFromString(tmp);
        tmp = mGoeLoopSkater1.getSelectedItem().toString();
        float goeLoop1 = getGoeLoopDeltaScoreFromString(tmp);
        tmp = mGoeFlipSkater1.getSelectedItem().toString();
        float goeFlip1 = getGoeFlipScoreFromString(tmp);
        tmp = mGoeLutzSkater1.getSelectedItem().toString();
        float goeLutz1 = getGoeLutzScoreFromString(tmp);
        tmp = mGoeAxelSkater1.getSelectedItem().toString();
        float goeAxel1 = getGoeAxelScoreFromFromString(tmp);
        /**
         * Reads the items from the "GOE" Spinners for Ice Skater 2.
         */
        tmp = mGoeToeLoopSkater2.getSelectedItem().toString();
        float goeToeLoop2 = getGoeToeLoopDeltaScoreFromString(tmp);
        tmp = mGoeSalchowSkater2.getSelectedItem().toString();
        float goeSalchow2 = getGoeSalchowDeltaScoreFromString(tmp);
        tmp = mGoeLoopSkater2.getSelectedItem().toString();
        float goeLoop2 = getGoeLoopDeltaScoreFromString(tmp);
        tmp = mGoeFlipSkater2.getSelectedItem().toString();
        float goeFlip2 = getGoeFlipScoreFromString(tmp);
        tmp = mGoeLutzSkater2.getSelectedItem().toString();
        float goeLutz2 = getGoeLutzScoreFromString(tmp);
        tmp = mGoeAxelSkater2.getSelectedItem().toString();
        float goeAxel2 = getGoeAxelScoreFromFromString(tmp);
        /**
         * Calculates the score for Ice Skater 1).
         * The score from the "Grade of Execution" will be added to the score for the
         difficulty of an element.i
         */
        float score1 = (toeLoop1 + goeToeLoop1) +
                (salchow1 + goeSalchow1) +
                (loop1 + goeLoop1) +
                (flip1 + goeFlip1) +
                (lutz1 + goeLutz1) +
                (axel1 + goeAxel1);
        /**
         * Calculates the score for Ice Skater 2).
         * The score from the "Grade of Execution" will be added to the score for the
         difficulty of an element.
         */
        float score2 = (toeLoop2 + goeToeLoop2) +
                (salchow2 + goeSalchow2) +
                (loop2 + goeLoop2) +
                (flip2 + goeFlip2) +
                (lutz2 + goeLutz2) +
                (axel2 + goeAxel2);
        /**
         * Display the score for Ice Skater 1 and 2.
         */

        displayForSkater1(score1);
        displayForSkater2(score2);
    }

    private float getGenericDeltaScoreFromStringToeLoop(String str) {
        /**
         * float[] deltas = {0f, 0.4f, 1.3f, 4.1f, 10.3f, -1f}; (for ToeLoop)
         */
        if (str.equals("0"))
            return 0f;
        if (str.equals("1"))
            return 0.4f;
        if (str.equals("2"))
            return 1.3f;
        if (str.equals("3"))
            return 4.1f;
        if (str.equals("4"))
            return 10.3f;
        /**
         * When the skater doesn't perform his element, but falls, a penalty of 1 point is
         being reduced from the skater's score).
         * This is being applied when from the spinner the value "F" is being selected.
         */
        return -1f;
    }

    private float getGenericDeltaScoreFromStringSalchow(String str) {
        /**
         * float[] deltas = {0f, 0.4f, 1.3f, 4.2f, 10.5f, -1f}; (for Salchow)
         */
        if (str.equals("0"))
            return 0f;
        if (str.equals("1"))
            return 0.4f;
        if (str.equals("2"))
            return 1.3f;
        if (str.equals("3"))
            return 4.2f;
        if (str.equals("4"))
            return 10.5f;
        return -1f;
    }

    private float getGenericDeltaScoreFromStringLoop(String str) {
        /**
         * float[] deltas = {0f, 0.5f, 1.8f, 5.1f, 12.3f, -1f}; (for Loop)
         */
        if (str.equals("0"))
            return 0f;
        if (str.equals("1"))
            return 0.5f;
        if (str.equals("2"))
            return 1.8f;
        if (str.equals("3"))
            return 5.1f;
        if (str.equals("4"))
            return 12f;
        return -1f;
    }

    private float getGenericDeltaScoreFromStringFlip(String str) {
        /**
         * float[] deltas = {0f, 0.5f, 1.8f, 5.3f, 12.3f, -1f}; (for Flip)
         */
        if (str.equals("0"))
            return 0f;
        if (str.equals("1"))
            return 0.5f;
        if (str.equals("2"))
            return 1.8f;
        if (str.equals("3"))
            return 5.3f;
        if (str.equals("4"))
            return 12.3f;
        return -1f;
    }

    private float getGenericDeltaScoreFromStringLutz(String str) {
        /**
         * float[] deltas = {0f, 0.6f, 2.1f, 6f, 13.6f, -1f}; (for Lutz)
         */
        if (str.equals("0"))
            return 0f;
        if (str.equals("1"))
            return 0.6f;
        if (str.equals("2"))
            return 2.1f;
        if (str.equals("3"))
            return 6f;
        if (str.equals("4"))
            return 13.6f;
        return -1f;
    }

    private float getGenericDeltaScoreFromStringAxel(String str) {
        /**
         * float[] deltas = {0f, 1.1f, 3.3f, 8.5f, 15f, -1f}; (for Axel)
         */
        if (str.equals("0"))
            return 0f;
        if (str.equals("1"))
            return 1.1f;
        if (str.equals("2"))
            return 3.3f;
        if (str.equals("3"))
            return 8.5f;
        if (str.equals("4"))
            return 15f;
        return -1f;
    }

    private float getGenericGoeDeltaScoreFromString(String str) {
        /**
         * gets the real value of each string-array of the spinner "Grade of Execution
         (GOE)".
         * The values are (-0.3, -0.2, -0.1, 0, 0.2, 0.4, 0.6).
         * "B" represents the base, also the basic score from which an element starts
         judged.
         * The value of "B" is 0, because there are no deviation from score that we have
         selected in the "difficulty" spinner.
         */
        if (str.equals("-3"))
            return -0.3f;
        if (str.equals("-2"))
            return -0.2f;
        if (str.equals("-1"))
            return -0.1f;
        if (str.equals("B"))
            return 0f;
        if (str.equals("+1"))
            return 0.2f;
        if (str.equals("+2"))
            return 0.4f;
        return 0.6f;
    }

    private float getToeLoopDeltaScoreFromString(String str) {
        return getGenericDeltaScoreFromStringToeLoop(str);
    }

    private float getSalchowDeltaScoreFromString(String str) {
        return getGenericDeltaScoreFromStringSalchow(str);
    }

    private float getLoopDeltaScoreFromString(String str) {
        return getGenericDeltaScoreFromStringLoop(str);
    }

    private float getFlipScoreFromString(String str) {
        return getGenericDeltaScoreFromStringFlip(str);
    }

    private float getLutzScoreFromString(String str) {
        return getGenericDeltaScoreFromStringLutz(str);
    }

    private float getAxelScoreFromFromString(String str) {
        return getGenericDeltaScoreFromStringAxel(str);
    }

    private float getGoeToeLoopDeltaScoreFromString(String str) {
        return getGenericGoeDeltaScoreFromString(str);
    }

    private float getGoeSalchowDeltaScoreFromString(String str) {
        return getGenericGoeDeltaScoreFromString(str);
    }

    private float getGoeLoopDeltaScoreFromString(String str) {
        return getGenericGoeDeltaScoreFromString(str);
    }

    private float getGoeFlipScoreFromString(String str) {
        return getGenericGoeDeltaScoreFromString(str);
    }

    private float getGoeLutzScoreFromString(String str) {
        return getGenericGoeDeltaScoreFromString(str);
    }

    private float getGoeAxelScoreFromFromString(String str) {
        return getGenericGoeDeltaScoreFromString(str);
    }

    /**
     * The method is empty because there is no action to perform here.
     * In the spinners there will be always something selected.
     * The method is still exists, because it's part of the OnItemSelectedListener.
     */
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /**
     * Resets the spinners values to the default position: "0" for "Difficulty" and "B" for GOE.
     * The displayed score is also initialized with 0.
     */
    public void resetScore(View view) {
        mToeLoopSkater1.setSelection(0);
        mToeLoopSkater2.setSelection(0);
        mSalchowSkater1.setSelection(0);
        mSalchowTSkater2.setSelection(0);
        mLoopSkater1.setSelection(0);
        mLoopSkater2.setSelection(0);
        mFlipSkater1.setSelection(0);
        mFlipSkater2.setSelection(0);
        mLutzSkater1.setSelection(0);
        mLutzSkater2.setSelection(0);
        mAxelSkater1.setSelection(0);
        mAxelSkater2.setSelection(0);
        mGoeToeLoopSkater1.setSelection(0);
        mGoeToeLoopSkater2.setSelection(0);
        mGoeSalchowSkater1.setSelection(0);
        mGoeSalchowSkater2.setSelection(0);
        mGoeLoopSkater1.setSelection(0);
        mGoeLoopSkater2.setSelection(0);
        mGoeFlipSkater1.setSelection(0);
        mGoeFlipSkater2.setSelection(0);
        mGoeLutzSkater1.setSelection(0);
        mGoeLutzSkater2.setSelection(0);
        mGoeAxelSkater1.setSelection(0);
        mGoeAxelSkater2.setSelection(0);
        updateScore();
    }

    public void displayForSkater1(float score1) {
        /**
         * formatting string with two decimals and display it
         */
        mSkaterScores[0] = score1;
        String val = String.format("TOTAL: " + "%.2f " + "points", mSkaterScores[0]);
        mScoreJumpsSkater1.setText(val);
    }

    public void displayForSkater2(float score2) {
        /**
         * formatting string with two decimals and display it
         */
        mSkaterScores[1] = score2;
        String val = String.format("TOTAL: " + "%.2f " + "points", mSkaterScores[1]);
        mScoreJumpsSkater2.setText(val);
    }

    /**
     * New intent for the left-bottom button of the screen, which makes connection to a
     * video o youtube.
     */
    public void videoButton1(View view) {
        String video_path = "https://www.youtube.com/watch?v=CrVL5tM926s&t=13s";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(video_path));
        startActivity(intent);
    }

    /**
     * New intent for the right-bottom button of the screen, which makes connection to a
     * video o youtube.
     */
    public void videoButton2(View view) {
        String video_path = "https://www.youtube.com/watch?v=hgXKJvTVW9g&t=36s";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(video_path));
        startActivity(intent);
    }

    /**
     * Restarts the activity every time we press the "start" button.
     */
    public void startThirdActivity(View view) {
        String name1 = getIntent().getExtras().getString("text1");
        String name2 = getIntent().getExtras().getString("text2");
        Intent main3Activity = new Intent(this, Main3Activity.class);
        main3Activity.putExtra("text1", name1);
        main3Activity.putExtra("text2", name2);
        main3Activity.putExtra("com.example.android.startpageice.Steps1Score", mSkaterScores[0]);
        main3Activity.putExtra("com.example.android.startpageice.Steps2Score", mSkaterScores[1]);
        startActivity(main3Activity);
    }
}


