package com.example.day06.Exam1;

import com.example.day06.Parent;

public class ElectricCar extends Car{
    int batteryCapacity;

    public ElectricCar(String brand, String model, int year, int batteryCapacity) {
        super(brand,model,year);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println(brand + " " + model + " " + year + " " + batteryCapacity);
    }
}
