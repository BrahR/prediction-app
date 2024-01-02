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

import com.example.application.*;
import com.example.application.algorithms.Bayes;
import com.example.application.algorithms.DT;
import com.example.application.algorithms.Knn;
import com.example.application.algorithms.PredictionAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class AlgorithmSelector extends AppCompatActivity {
    public final HashMap<String, PredictionAlgorithm> algorithms = new HashMap<>() {{
        put("knn", new Knn());
        put("bayes", new Bayes());
        put("dt", new DT());
    }};

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
            String selectedRadio = String.valueOf(radioGroup1.getCheckedRadioButtonId());

            EditText kEditor = findViewById(R.id.editText4);
            int k = kEditor != null ? Integer.parseInt(kEditor.getText().toString()) : 0;

            String origin = algorithms.get(selectedRadio.toLowerCase()).calc(car, k);
            System.out.println(origin);
            Intent intent2 = new Intent(AlgorithmSelector.this, AlgorithmResults.class);
            intent2.putExtra("origin", origin);
            startActivity(intent2);
        });
    }
}
