package com.example.android.startpageice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * The Intent opens the second screen by clicking the START Button in the first activity.
     */
    public void startSecondActivity(View view) {
        Intent main2Activity = new Intent(this, Main2Activity.class);
        startActivity(main2Activity);
    }
}
