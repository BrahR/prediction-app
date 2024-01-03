package com.example.application.activities;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.application.*;
import com.example.application.algorithms.Bayes;
import com.example.application.algorithms.DT;
import com.example.application.algorithms.Knn;

import java.util.ArrayList;
import java.util.Locale;

public class AlgorithmSelector extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button myButton = findViewById(R.id.Button);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RelativeLayout radio = findViewById(R.id.Kinput);
                View knn = findViewById(R.id.knn);
                View dt = findViewById(R.id.dt);

                ViewGroup.MarginLayoutParams KnnParams = (ViewGroup.MarginLayoutParams) knn.getLayoutParams();
                ViewGroup.MarginLayoutParams DtParams = (ViewGroup.MarginLayoutParams) dt.getLayoutParams();

                if (checkedId == R.id.knn) {
                    DtParams.topMargin = (int) (90 * getResources().getDisplayMetrics().density);
                    dt.setLayoutParams(DtParams);

                    KnnParams.topMargin = (int) (250 * getResources().getDisplayMetrics().density);
                    knn.setLayoutParams(KnnParams);
                    radio.setVisibility(View.VISIBLE);
                } else {
                    DtParams.topMargin = (int) (20 * getResources().getDisplayMetrics().density);
                    dt.setLayoutParams(DtParams);

                    KnnParams.topMargin = (int) (300 * getResources().getDisplayMetrics().density);
                    knn.setLayoutParams(KnnParams);
                    radio.setVisibility(View.GONE);
                }
            }
        });

        myButton.setOnClickListener(v -> {
            Intent intent = getIntent();
            Car car = (Car) intent.getSerializableExtra("car");

            RadioGroup radioGroup1 = findViewById(R.id.RadioGroup);
            int selectedRadio = radioGroup.getCheckedRadioButtonId();

            if (radioGroup.getCheckedRadioButtonId() !=- 1) {
                String origin;
                double precision;
                double recall;
                double fScore;
                double accuracy;

                if (selectedRadio==R.id.knn) {
                    try {
                        Knn.predictedData = new ArrayList<>();
                        EditText editText = findViewById(R.id.editText4);
                        int k = Integer.parseInt(editText.getText().toString());
                        System.out.println(k);
                        Knn knn = new Knn();
                        knn.predict(k);

                        origin = Knn.calc(car, k);
                        precision = knn.macroPrecision();
                        recall = knn.macroRecall();
                        fScore = knn.macroFScore();
                        accuracy = knn.getAccuracy();
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Please enter valid numbers in all fields", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else if (selectedRadio==R.id.bayes) {
                    Bayes bayes = new Bayes();
                    origin = Bayes.calc(car);
                    precision = bayes.macroPrecision();
                    recall = bayes.macroRecall();
                    fScore = bayes.macroFScore();
                    accuracy = bayes.getAccuracy();
                } else {
                    DT dt = new DT();
                    origin = DT.calc(car);
                    precision = dt.macroPrecision();
                    recall = dt.macroRecall();
                    fScore = dt.macroFScore();
                    accuracy = dt.getAccuracy();
                }

                Intent intent2 = new Intent(AlgorithmSelector.this, AlgorithmResults.class);
                intent2.putExtra("origin", origin);
                intent2.putExtra("precision", String.format(Locale.US, "%.2f", precision * 100));
                intent2.putExtra("recall", String.format(Locale.US, "%.2f", recall * 100));
                intent2.putExtra("fScore", String.format(Locale.US, "%.2f", fScore * 100));
                intent2.putExtra("accuracy", String.format(Locale.US, "%.2f", accuracy * 100));
                startActivity(intent2);
            } else {
                Toast.makeText(getApplicationContext(), "Please select a ML algorithm", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
