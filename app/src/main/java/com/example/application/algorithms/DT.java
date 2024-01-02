package com.example.application.algorithms;

import com.example.application.Car;

public class DT implements PredictionAlgorithm {
    public static void buildClassedData() {

    }

    @Override
    public String calc(Car car) {
        String origin;
        if (car.getWeight() <= 1812.5) {
            if (car.getDisplacement() <= 94.5) {
                origin = "Japanese";
            } else {
                origin = "American";
            }
        } else {
            if (car.getHorsePower() <= 63.5) {
                origin = "European";
            } else {
                origin = "Japanese";
            }
        }
        return "Your car is " + origin;
    }

    @Override
    public String calc(Car car, int k) {
        return this.calc(car);
    }
}