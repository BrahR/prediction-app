package com.example.application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.application.Car;
import com.example.application.R;

public class CarForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.Button);
        myButton.setOnClickListener(v -> {
            EditText mgpText = findViewById(R.id.editText1);
            int mgp = Integer.parseInt(mgpText.getText().toString());
            EditText displacementText = findViewById(R.id.editText2);
            int displacement = Integer.parseInt(displacementText.getText().toString());
            EditText accelerationText = findViewById(R.id.editText3);
            int acceleration = Integer.parseInt(accelerationText.getText().toString());
            EditText weightText = findViewById(R.id.editText4);
            int weight = Integer.parseInt(weightText.getText().toString());
            EditText horsePowerText = findViewById(R.id.editText5);
            int horsePower = Integer.parseInt(horsePowerText.getText().toString());

            Car car = new Car(mgp, displacement, acceleration, weight, horsePower);

            Intent intent = new Intent(CarForm.this, AlgorithmSelector.class);
            intent.putExtra("car", car);
            startActivity(intent);
        });
    }
}