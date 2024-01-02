package com.example.application;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;

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
            Log.i("App", "CARS Loading data");
            if (Car.data == null) Car.loadCSV(getResources().openRawResource(R.raw.data));
            Log.v("App", "CARS Cars Loaded");
            Log.v("App", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
