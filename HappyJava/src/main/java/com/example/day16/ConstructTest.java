package com.example.day16;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class Car {
    String name;
    String speed;

    public Car() {

    }

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, String speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return name + "," + speed;
    }
}

public class ConstructTest {
    public static void main(String[] args) {
        Function<String, Car> func = name -> new Car(name);
        Car car = func.apply("tico");
        System.out.println(car.name);

        Function<String, Car> func2 = Car :: new;
        Car car2 = func2.apply("matiz");
        System.out.println(car2.name);

        BiFunction<String, String, Car> func3 = Car :: new;
        Car car3 = func3.apply("모닝", "100");
        System.out.println(car3);

        Supplier<Car> sup = Car :: new;
        Car supCar = sup.get();
        System.out.println(supCar.name);
    }
}
