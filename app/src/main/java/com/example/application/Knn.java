package com.example.application;

import java.io.FileNotFoundException;
import java.util.*;

public class Knn {

    static List<Car> data;

    static {
        try {
            data = Car.loadCSV("data.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String calc(Car car, int k) {
        ArrayList<Double> distances = new ArrayList<>();
        for (Car c : data) {
            distances.add(car.distance(c));
        }

        ArrayList<Double> sortedDistances = new ArrayList<>(distances);
        Collections.sort(sortedDistances);

        HashMap<String, Integer> origins = new HashMap<>();
        origins.put(Car.ORIGINS[0], 0);
        origins.put(Car.ORIGINS[1], 0);
        origins.put(Car.ORIGINS[2], 0);

        for (int i = 0; i < k; i++) {
            int index = distances.indexOf(sortedDistances.get(i));

            String origin = data.get(index).getOrigin();
            origins.put(origin, origins.get(origin) + 1);
        }


        return "Your car is "+Collections.max(origins.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();


    }


}
