package com.example.application.activities;

import android.annotation.SuppressLint;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.application.R;

public class AlgorithmResults extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        TextView textView = findViewById(R.id.result);
        String origin = intent.getStringExtra("origin");
        assert origin != null;
        textView.setText("Your car is " + origin.substring(0, 1).toUpperCase() + origin.substring(1) + "!");
        TextView precision = findViewById(R.id.precision);
        precision.setText(intent.getStringExtra("precision") + "%");
        TextView recall = findViewById(R.id.recall);
        recall.setText(intent.getStringExtra("recall") + "%");
        TextView fScore = findViewById(R.id.fScore);
        fScore.setText(intent.getStringExtra("fScore") + "%");
        TextView accuracy = findViewById(R.id.accuracy);
        accuracy.setText(intent.getStringExtra("accuracy") + "%");
    }
}
