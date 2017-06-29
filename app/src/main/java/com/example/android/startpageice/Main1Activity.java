package com.example.android.startpageice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    public void getSkater1Name(View view) {
        EditText nameField1 = (EditText) findViewById(R.id.fillSkater1);
        EditText nameField2 = (EditText) findViewById(R.id.fillSkater2);
        String name1 = nameField1.getText().toString();
        String name2 = nameField2.getText().toString();
        if ((name1.length() == 0) || (name2.length() == 0)) {
            // The name can not be empty to continue
            Context context = getApplicationContext();
            CharSequence text = "Please fill your name!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }

        Intent main2Activity = new Intent(this, Main2Activity.class);
        main2Activity.putExtra("text1", name1);
        main2Activity.putExtra("text2", name2);
        startActivity(main2Activity);
    }
}
