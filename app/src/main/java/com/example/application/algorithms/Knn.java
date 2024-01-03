package com.example.application.algorithms;

import android.util.Log;

import com.example.application.Car;

import java.util.*;

public class Knn extends Metrics {
    public void predict(int k) {
        for (Car car : Car.data) {
            String predicted = calc(car, k);
            predictedData.add(predicted);
        }
    }

    public static String calc(Car car, int k) {
        ArrayList<Double> distances = new ArrayList<>();
        for (Car c : Car.data) {
            distances.add(car.distance(c));
        }

        ArrayList<Double> sortedDistances = new ArrayList<>(distances);
        Collections.sort(sortedDistances);

        HashMap<String, Integer> origins = new HashMap<>();
        origins.put(Car.ORIGINS[0], 0);
        origins.put(Car.ORIGINS[1], 0);
        origins.put(Car.ORIGINS[2], 0);

        for (int i = 0; i < k; i++) {
            double distance = sortedDistances.get(i);
            int index = distances.indexOf(distance);
            String origin = Car.data.get(index).getOrigin();
            origins.put(origin, origins.get(origin) + 1);
        }

        return Collections.max(origins.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

//        return "Your car is " + Collections.max(origins.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}