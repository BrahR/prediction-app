package com.example.application;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;

import com.example.application.algorithms.Bayes;
import com.example.application.algorithms.DT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App extends Application {
    public App() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            Log.v("App", "CARS Loading data");
            if (Car.data == null) Car.loadCSV(getResources().openRawResource(R.raw.data));
            Log.i("App", "CARS Cars Loaded");

            Log.i("App", "CARS Predicting");
            new DT().predict(0);
            new Bayes().predict(0);
            Log.i("App", "CARS Predicted");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
