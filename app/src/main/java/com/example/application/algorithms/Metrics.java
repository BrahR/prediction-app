package com.example.application.algorithms;

import android.util.Log;

import com.example.application.Car;

import java.util.ArrayList;

public abstract class Metrics {
    public static ArrayList<String> predictedData = new ArrayList<>();
    public abstract void predict(int k);
    public double getAccuracy() {
        int correct = 0;
        for (int i = 0; i < Car.data.size(); i++) {
            if (Car.data.get(i).getOrigin().equals(predictedData.get(i))) correct++;
        }

        return (double) correct / Car.data.size();
    }

    public double precision(String origin) {
        ConfusionMatrix cm = new ConfusionMatrix();
        for (int i = 0; i < Car.data.size(); i++) {
            cm.updateCounts(Car.data.get(i).getOrigin().equals(origin), predictedData.get(i).equals(origin));
        }

        return cm.getPrecision();
    }

    public double recall(String origin) {
        ConfusionMatrix cm = new ConfusionMatrix();
        for (int i = 0; i < Car.data.size(); i++) {
            cm.updateCounts(Car.data.get(i).getOrigin().equals(origin), predictedData.get(i).equals(origin));
        }

        return cm.getRecall();
    }

    public double f1(String origin) {
        double precision = precision(origin);
        double recall = recall(origin);
        return (precision + recall != 0) ? 2 * ((precision * recall) / (precision + recall)) : 0;
    }

    public double macroPrecision() {
        double precision = 0;
        for (String origin : Car.ORIGINS) {
            precision += precision(origin);
        }

        return precision / Car.ORIGINS.length;
    }

    public double macroRecall() {
        double recall = 0;
        for (String origin : Car.ORIGINS) {
            recall += recall(origin);
        }

        return recall / Car.ORIGINS.length;
    }

    public double macroFScore() {
        double f1 = 0;
        for (String origin : Car.ORIGINS) {
            f1 += f1(origin);
        }

        return f1 / Car.ORIGINS.length;
    }
}