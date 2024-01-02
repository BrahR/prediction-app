package com.example.application;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.Serializable;
import java.util.*;

public class Car implements Serializable {
    public static final String[] ORIGINS = {"american", "european", "japanese"};
    @CsvBindByPosition(position = 0)
    private int milesPerGallon;
    @CsvBindByPosition(position = 1)
    private int displacement;
    @CsvBindByPosition(position = 2)
    private int horsePower;
    @CsvBindByPosition(position = 3)
    private int weight;
    @CsvBindByPosition(position = 4)
    private int acceleration;
    @CsvBindByPosition(position = 5)
    private String origin;

    public Car() { }

    public Car(int milesPerGallon, int displacement, int horsePower, int weight, int acceleration, String origin) {
        this.milesPerGallon = milesPerGallon;
        this.displacement = displacement;
        this.horsePower = horsePower;
        this.weight = weight;
        this.acceleration = acceleration;
        this.origin = origin;
    }
    public Car(int milesPerGallon, int displacement, int horsePower, int weight, int acceleration) {
        this.milesPerGallon = milesPerGallon;
        this.displacement = displacement;
        this.horsePower = horsePower;
        this.weight = weight;
        this.acceleration = acceleration;
    }

    public static List<Car> loadCSV(String file) throws FileNotFoundException {
        Reader reader = new BufferedReader(new FileReader("src/main/res/raw/" + file));
        CsvToBean<Car> csvReader = new CsvToBeanBuilder<Car>(reader)
                .withType(Car.class)
                .withSeparator(',')
                .withIgnoreEmptyLine(true)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return csvReader.parse();
    }


    public double distance(Car car) {
        return Math.sqrt(Math.pow(this.milesPerGallon - car.milesPerGallon,2)) +
                Math.sqrt(Math.pow(this.displacement - car.displacement,2)) +
                Math.sqrt(Math.pow(this.horsePower - car.horsePower,2)) +
                Math.sqrt(Math.pow(this.weight - car.weight,2)) +
                Math.sqrt(Math.pow(this.acceleration - car.acceleration,2));
    }

    public static String[] getOrigins() {
        return ORIGINS;
    }

    public int getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(int milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "milesPerGallon=" + milesPerGallon +
                ", displacement=" + displacement +
                ", horsePower=" + horsePower +
                ", weight=" + weight +
                ", acceleration=" + acceleration +
                ", origin='" + origin + '\'' +
                '}';
    }
}
