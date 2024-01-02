package com.example.application.algorithms;

import com.example.application.Car;

public interface PredictionAlgorithm {
    String calc(Car car);
    String calc(Car car, int k);
}
