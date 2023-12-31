package com.example.application;

public class DT {
    public static String calc(Car car){
        String origin;
        if(car.getWeight()<=1812.5){
            if(car.getDisplacement()<=94.5){
                origin="Japanese";
            }else{
                origin="American";
            }
        }else{
            if(car.getHorsePower()<=63.5){
                origin="European";
            }else{
                origin="Japanese";
            }
        }
        return "Your car is "+origin;
    }

}
