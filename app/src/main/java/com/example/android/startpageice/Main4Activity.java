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

public class Main4Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    /**
     * Declaration of the 16 Spinners: 4 Spinners for "Difficulty" and 4 Spinners for the
     * "Grade of Execution" for each ice skater.
     * Declaration of the 2 TextViews, in which the score for each ice skater will be
     * shown.
     * Declaration of the starting scores (default scores) - > mSkaterScores
     */
    Spinner mUprightSkater1;
    Spinner mUprightSkater2;
    Spinner mLaybackSkater1;
    Spinner mLaybackSkater2;
    Spinner mCamelSkater1;
    Spinner mCamelSkater2;
    Spinner mSitSkater1;
    Spinner mSitSkater2;
    Spinner mGoeUprightSkater1;
    Spinner mGoeUprightSkater2;
    Spinner mGoeLaybackSkater1;
    Spinner mGoeLaybackSkater2;
    Spinner mGoeCamelSkater1;
    Spinner mGoeCamelSkater2;
    Spinner mGoeSitSkater1;
    Spinner mGoeSitSkater2;
    TextView mScoreSpinsSkater1;
    TextView mScoreSpinsSkater2;
    float[] mSkaterScores = {0f, 0f};
    private float mScore1Steps;
    private float mScore2Steps;
    private float mScore1Jumps;
    private float mScore2Jumps;

    private void initScore() {
        Intent i = getIntent();
        mScore1Steps = i.getFloatExtra("com.example.android.startpageice.Steps1Score", 0);
        mScore2Steps = i.getFloatExtra("com.example.android.startpageice.Steps2Score", 0);
        mScore1Jumps = i.getFloatExtra("com.example.android.startpageice.Jumps1Score", 0);
        mScore2Jumps = i.getFloatExtra("com.example.android.startpageice.Jumps2Score", 0);
        // when we go back from Main5Activity we have those values set:
        // (alghtough right now there is no back from Main5Activity)
        mSkaterScores[0] = i.getFloatExtra("com.example.android.startpageice.Spins1Score", 0);
        mSkaterScores[1] = i.getFloatExtra("com.example.android.startpageice.Spins2Score", 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("andre", "in activity 5");
        setContentView(R.layout.activity_main4);
        initScore();
        mUprightSkater1 = (Spinner) findViewById(R.id.upright1);
        mLaybackSkater1 = (Spinner) findViewById(R.id.layback1);
        mCamelSkater1 = (Spinner) findViewById(R.id.camel1);
        mSitSkater1 = (Spinner) findViewById(R.id.sit1);
        mUprightSkater2 = (Spinner) findViewById(R.id.upright2);
        mLaybackSkater2 = (Spinner) findViewById(R.id.layback2);
        mCamelSkater2 = (Spinner) findViewById(R.id.camel2);
        mSitSkater2 = (Spinner) findViewById(R.id.sit2);
        mGoeUprightSkater1 = (Spinner) findViewById(R.id.goeUpright1);
        mGoeLaybackSkater1 = (Spinner) findViewById(R.id.goeLayback1);
        mGoeCamelSkater1 = (Spinner) findViewById(R.id.goeCamel1);
        mGoeSitSkater1 = (Spinner) findViewById(R.id.goeSit1);
        mGoeUprightSkater2 = (Spinner) findViewById(R.id.goeUpright2);
        mGoeLaybackSkater2 = (Spinner) findViewById(R.id.goeLayback2);
        mGoeCamelSkater2 = (Spinner) findViewById(R.id.goeCamel2);
        mGoeSitSkater2 = (Spinner) findViewById(R.id.goeSit2);
        mScoreSpinsSkater1 = (TextView) findViewById(R.id.scoreSpinsSkater1);
        mScoreSpinsSkater2 = (TextView) findViewById(R.id.scoreSpinsSkater2);
        /**
         * We want to be notified when the items are changing.
         * In this case, "onItemSelected" and "onNothingSelected" will be called.
         */
        mUprightSkater1.setOnItemSelectedListener(this);
        mUprightSkater2.setOnItemSelectedListener(this);
        mLaybackSkater1.setOnItemSelectedListener(this);
        mLaybackSkater2.setOnItemSelectedListener(this);
        mCamelSkater1.setOnItemSelectedListener(this);
        mCamelSkater2.setOnItemSelectedListener(this);
        mSitSkater1.setOnItemSelectedListener(this);
        mSitSkater2.setOnItemSelectedListener(this);
        mGoeUprightSkater1.setOnItemSelectedListener(this);
        mGoeUprightSkater2.setOnItemSelectedListener(this);
        mGoeLaybackSkater1.setOnItemSelectedListener(this);
        mGoeLaybackSkater2.setOnItemSelectedListener(this);
        mGoeCamelSkater1.setOnItemSelectedListener(this);
        mGoeCamelSkater2.setOnItemSelectedListener(this);
        mGoeSitSkater1.setOnItemSelectedListener(this);
        mGoeSitSkater2.setOnItemSelectedListener(this);
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
        tmp = mUprightSkater1.getSelectedItem().toString();
        float upright1 = getUprightDeltaScoreFromString(tmp);
        tmp = mLaybackSkater1.getSelectedItem().toString();
        float layback1 = getLaybackDeltaScoreFromString(tmp);
        tmp = mCamelSkater1.getSelectedItem().toString();
        float camel1 = getCamelDeltaScoreFromString(tmp);
        tmp = mSitSkater1.getSelectedItem().toString();
        float sit1 = getSitScoreFromString(tmp);
        /**
         * Reads the items from the "Difficulty" Spinners for Ice Skater 2.
         */
        tmp = mUprightSkater2.getSelectedItem().toString();
        float upright2 = getUprightDeltaScoreFromString(tmp);
        tmp = mLaybackSkater2.getSelectedItem().toString();
        float layback2 = getLaybackDeltaScoreFromString(tmp);
        tmp = mCamelSkater2.getSelectedItem().toString();
        float camel2 = getCamelDeltaScoreFromString(tmp);
        tmp = mSitSkater2.getSelectedItem().toString();
        float sit2 = getSitScoreFromString(tmp);
        /**
         * Reads the items from the "GOE" Spinners for Ice Skater 1.
         */
        tmp = mGoeUprightSkater1.getSelectedItem().toString();
        float goeUpright1 = getGoeUprightDeltaScoreFromString(tmp);
        tmp = mGoeLaybackSkater1.getSelectedItem().toString();
        float goeLayback1 = getGoeLaybackDeltaScoreFromString(tmp);
        tmp = mGoeCamelSkater1.getSelectedItem().toString();
        float goeCamel1 = getGoeCamelDeltaScoreFromString(tmp);
        tmp = mGoeSitSkater1.getSelectedItem().toString();
        float goeSit1 = getGoeSitScoreFromString(tmp);
        /**
         * Reads the items from the "GOE" Spinners for Ice Skater 2.
         */
        tmp = mGoeUprightSkater2.getSelectedItem().toString();
        float goeUpright2 = getGoeUprightDeltaScoreFromString(tmp);
        tmp = mGoeLaybackSkater2.getSelectedItem().toString();
        float goeLayback2 = getGoeLaybackDeltaScoreFromString(tmp);
        tmp = mGoeCamelSkater2.getSelectedItem().toString();
        float goeCamel2 = getGoeCamelDeltaScoreFromString(tmp);
        tmp = mGoeSitSkater2.getSelectedItem().toString();
        float goeSit2 = getGoeSitScoreFromString(tmp);
        /**
         * Calculates the score for Ice Skater 1).
         * The score from the "Grade of Execution" will be added to the score for the
         difficulty of an element.i
         */
        float score1 = (upright1 + goeUpright1) +
                (layback1 + goeLayback1) +
                (camel1 + goeCamel1) +
                (sit1 + goeSit1);
        /**
         * Calculates the score for Ice Skater 2).
         * The score from the "Grade of Execution" will be added to the score for the
         difficulty of an element.
         */
        float score2 = (upright2 + goeUpright2) +
                (layback2 + goeLayback2) +
                (camel2 + goeCamel2) +
                (sit2 + goeSit2);
        /**
         * Display the score for Ice Skater 1 and 2.
         */
        displayForSkater1(score1);
        displayForSkater2(score2);
    }

    private float getGenericDeltaScoreFromStringUpright(String str) {
        /**
         * float[] deltas = {0f, 0.4f, 1.3f, 4.1f, 10.3f, -1f}; (for Upright)
         */
        if (str.equals("0"))
            return 0f;
        if (str.equals("B"))
            return 1f;
        if (str.equals("1"))
            return 1.2f;
        if (str.equals("2"))
            return 1.5f;
        if (str.equals("3"))
            return 1.9f;
        if (str.equals("4"))
            return 2.4f;
        /**
         * When the skater doesn't perform his element, but falls, a penalty of 1 point is
         being reduced from the skater's score).
         * This is being applied when from the spinner the value "F" is being selected.
         */
        return -1f;
    }

    private float getGenericDeltaScoreFromStringLayback(String str) {
        /**
         * float[] deltas = {0f, 0.4f, 1.3f, 4.2f, 10.5f, -1f}; (for Layback)
         */
        if (str.equals("0"))
            return 0f;
        if (str.equals("B"))
            return 1.2f;
        if (str.equals("1"))
            return 1.5f;
        if (str.equals("2"))
            return 1.9f;
        if (str.equals("3"))
            return 2.4f;
        if (str.equals("4"))
            return 2.7f;
        return -1f;
    }

    private float getGenericDeltaScoreFromStringCamel(String str) {
        /**
         * float[] deltas = {0f, 0.5f, 1.8f, 5.1f, 12.3f, -1f}; (for Camel)
         */
        if (str.equals("0"))
            return 0f;
        if (str.equals("B"))
            return 1.1f;
        if (str.equals("1"))
            return 1.4f;
        if (str.equals("2"))
            return 1.8f;
        if (str.equals("3"))
            return 2.3f;
        if (str.equals("4"))
            return 2.6f;
        return -1f;
    }

    private float getGenericDeltaScoreFromStringSit(String str) {
        /**
         * float[] deltas = {0f, 0.5f, 1.8f, 5.3f, 12.3f, -1f}; (for Sit)
         */
        if (str.equals("0"))
            return 0f;
        if (str.equals("B"))
            return 1.1f;
        if (str.equals("1"))
            return 1.3f;
        if (str.equals("2"))
            return 1.6f;
        if (str.equals("3"))
            return 2.1f;
        if (str.equals("4"))
            return 2.5f;
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

    private float getUprightDeltaScoreFromString(String str) {
        return getGenericDeltaScoreFromStringUpright(str);
    }

    private float getLaybackDeltaScoreFromString(String str) {
        return getGenericDeltaScoreFromStringLayback(str);
    }

    private float getCamelDeltaScoreFromString(String str) {
        return getGenericDeltaScoreFromStringCamel(str);
    }

    private float getSitScoreFromString(String str) {
        return getGenericDeltaScoreFromStringSit(str);
    }

    private float getGoeUprightDeltaScoreFromString(String str) {
        return getGenericGoeDeltaScoreFromString(str);
    }

    private float getGoeLaybackDeltaScoreFromString(String str) {
        return getGenericGoeDeltaScoreFromString(str);
    }

    private float getGoeCamelDeltaScoreFromString(String str) {
        return getGenericGoeDeltaScoreFromString(str);
    }

    private float getGoeSitScoreFromString(String str) {
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
        mUprightSkater1.setSelection(0);
        mUprightSkater2.setSelection(0);
        mLaybackSkater1.setSelection(0);
        mLaybackSkater2.setSelection(0);
        mCamelSkater1.setSelection(0);
        mCamelSkater2.setSelection(0);
        mSitSkater1.setSelection(0);
        mSitSkater2.setSelection(0);
        mGoeUprightSkater1.setSelection(0);
        mGoeUprightSkater2.setSelection(0);
        mGoeLaybackSkater1.setSelection(0);
        mGoeLaybackSkater2.setSelection(0);
        mGoeCamelSkater1.setSelection(0);
        mGoeCamelSkater2.setSelection(0);
        mGoeSitSkater1.setSelection(0);
        mGoeSitSkater2.setSelection(0);
        updateScore();
    }

    public void displayForSkater1(float score1) {
        /**
         * formatting string with two decimals and display it
         */
        mSkaterScores[0] = score1;
        String val = String.format("TOTAL: " + "%.2f " + "points", mSkaterScores[0]);
        mScoreSpinsSkater1.setText(val);
    }

    public void displayForSkater2(float score2) {
        /**
         * formatting string with two decimals and display it
         */
        mSkaterScores[1] = score2;
        String val = String.format("TOTAL: " + "%.2f " + "points", mSkaterScores[1]);
        mScoreSpinsSkater2.setText(val);
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
        Log.d("andre", "in activity 5. starting video2");
        String video_path = "https://www.youtube.com/watch?v=hgXKJvTVW9g&t=36s";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(video_path));
        startActivity(intent);
    }

    /**
     * Restarts the activity every time we press the "start" button.
     */
    public void startThirdActivity(View view) {

        Intent main3Activity = new Intent(this, Main3Activity.class);
        // When we go back we want to preserve the old values.
        // We have created a new intent Main3Activity, let's restore saved values to it:
        main3Activity.putExtra("com.example.android.startpageice.Steps1Score", mScore1Steps);
        main3Activity.putExtra("com.example.android.startpageice.Steps2Score", mScore2Steps);
        main3Activity.putExtra("com.example.android.startpageice.Jumps1Score", mScore1Jumps);
        main3Activity.putExtra("com.example.android.startpageice.Jumps2Score", mScore2Jumps);
        startActivity(main3Activity);
    }

    public void startSixthActivity(View view) {

        String name1 = getIntent().getExtras().getString("caca1");
        String name2 = getIntent().getExtras().getString("caca2");

        Intent main5Activity = new Intent(this, Main5Activity.class);
        main5Activity.putExtra("caca1", name1);
        main5Activity.putExtra("caca2", name2);
        main5Activity.putExtra("com.example.android.startpageice.Steps1Score", mScore1Steps);
        main5Activity.putExtra("com.example.android.startpageice.Steps2Score", mScore2Steps);
        main5Activity.putExtra("com.example.android.startpageice.Jumps1Score", mScore1Jumps);
        main5Activity.putExtra("com.example.android.startpageice.Jumps2Score", mScore2Jumps);
        main5Activity.putExtra("com.example.android.startpageice.Spins1Score", mSkaterScores[0]);
        main5Activity.putExtra("com.example.android.startpageice.Spins2Score", mSkaterScores[1]);
        startActivity(main5Activity);
    }
}