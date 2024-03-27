package com.example.day06;

public class Car {
    String name;
    int speed;

    public Car() {
        System.out.println("Car의 생성자 호출");
    }

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    public Car(String name) {
        this(name,0);
    }

    public Car(int speed) {
        this("",speed);
    }
}
