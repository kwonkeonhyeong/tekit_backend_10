package com.example.day07;

public class Circle extends Figure implements Drawable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculate() {
        return 2*3.14*radius;
    }

    @Override
    public void draw() {
        System.out.println("원을 그립니다.");
    }
}
