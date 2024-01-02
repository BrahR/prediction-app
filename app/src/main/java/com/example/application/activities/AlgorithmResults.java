package com.example.application.activities;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.application.R;

public class AlgorithmResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String origin = intent.getStringExtra("origin");
        TextView textView = findViewById(R.id.result);
        textView.setText(origin);
    }
}
