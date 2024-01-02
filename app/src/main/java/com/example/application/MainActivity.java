package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.Button);

        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    EditText editText = findViewById(R.id.editText1);
                    int mgp = Integer.parseInt(editText.getText().toString());
                    EditText editText2 = findViewById(R.id.editText2);
                    int displacement = Integer.parseInt(editText2.getText().toString());
                    EditText editText3 = findViewById(R.id.editText3);
                    int acceleration = Integer.parseInt(editText3.getText().toString());
                    EditText editText4 = findViewById(R.id.editText4);
                    int weight = Integer.parseInt(editText4.getText().toString());
                    EditText editText5 = findViewById(R.id.editText5);
                    int horsePower = Integer.parseInt(editText5.getText().toString());
                    Car car=new Car(mgp, displacement, acceleration, weight, horsePower);
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("car", car);
                    startActivity(intent);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Please enter valid numbers in all fields", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

}