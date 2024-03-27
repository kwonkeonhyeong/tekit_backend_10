package com.example.day06;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car("벤틀니");
        System.out.println(car.name);
        System.out.println(car.speed);

        Bus bus = new Bus("봉봉쓰");
        System.out.println(bus.name);
        System.out.println(bus.speed);
    }
}
