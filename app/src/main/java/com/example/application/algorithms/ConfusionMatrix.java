package com.example.application.algorithms;

public class ConfusionMatrix {
    private int tp = 0;
    private int tn = 0;
    private int fp = 0;
    private int fn = 0;

    public void updateCounts(boolean actual, boolean predicted) {
        if (actual && predicted) tp++;
        if (!actual && !predicted) tn++;
        if (actual) fn++;
        if (!actual) fp++;
    }

    public double getAccuracy() {
        return (double) (tp + tn) / (tp + tn + fp + fn);
    }

    public double getPrecision() {
        return (double) tp / (tp + fp);
    }

    public double getRecall() {
        return (double) tp / (tp + fn);
    }

    public double getFScore() {
        double precision = getPrecision();
        double recall = getRecall();
        return 2 * ((precision * recall) / (precision + recall));
    }
}