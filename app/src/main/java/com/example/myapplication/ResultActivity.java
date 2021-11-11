package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.xml.transform.Result;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent getIntent_Intent1 = getIntent();

        int total = getIntent_Intent1.getIntExtra("Total", 0);
        int right = getIntent_Intent1.getIntExtra("Result", 0);
        TextView view1 = (TextView) findViewById(R.id.textView4);
        view1.setText("Your Result is "+ right+" / "+total);
    }
}