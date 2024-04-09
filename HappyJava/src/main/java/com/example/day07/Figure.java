package com.example.day07;

abstract public class Figure implements Drawable{
    abstract public double calculate();
}

class Triangle extends Figure implements Drawable {
    private double width;
    private double height;

    public Triangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculate() {
        return (width*height)/2;
    }

    @Override
    public void draw() {
        System.out.println("삼각형을 그립니다.");
    }
}

class Rectangle extends Figure implements Drawable{
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculate() {
        return width*height;
    }

    @Override
    public void draw() {
        System.out.println("사각형을 그립니다.");
    }
}

