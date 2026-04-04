package com.gla.wrapperclass;

import java.util.ArrayList;

public class SensorDataLogger {

    public static void storeTemperature(ArrayList<Double> log, double temperature) {
        Double boxed = temperature;
        log.add(boxed);
    }

    public static double readTemperature(ArrayList<Double> log, int index) {
        Double boxed = log.get(index);
        double unboxed = boxed;
        return unboxed;
    }

    public static void main(String[] args) {
        ArrayList<Double> temperatureLog = new ArrayList<>();

        double temp1 = 36.5;
        double temp2 = 37.1;
        double temp3 = 36.8;
        double temp4 = 38.2;

        storeTemperature(temperatureLog, temp1);
        storeTemperature(temperatureLog, temp2);
        storeTemperature(temperatureLog, temp3);
        storeTemperature(temperatureLog, temp4);

        System.out.println("Stored Temperatures: " + temperatureLog);

        for (int i = 0; i < temperatureLog.size(); i++) {
            double reading = readTemperature(temperatureLog, i);
            System.out.println("Reading " + (i + 1) + ": " + reading + " C");
        }

        Double wrapperTemp = 39.0;
        storeTemperature(temperatureLog, wrapperTemp);
        System.out.println("After adding wrapper input: " + temperatureLog);
    }
}
