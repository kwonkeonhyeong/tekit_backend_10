package com.example.day07;

public class FigureMain {
    public static void main(String[] args) {
        Figure triangle = new Triangle(10, 5);
        System.out.println("삼각형의 너비: " + triangle.calculate());
        ((Triangle) triangle).draw();

        Figure rectangle = new Rectangle(10, 20);
        System.out.println("사각형의 너비: " + rectangle.calculate());
        ((Rectangle) rectangle).draw();

        Figure circle = new Circle(20);
        System.out.println("원의 너비: " + circle.calculate());
        ((Circle) circle).draw();
        ((Circle) circle).defaultDraw();
        circle.defaultDraw();

    }
}
