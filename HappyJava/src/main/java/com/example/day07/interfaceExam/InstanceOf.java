package com.example.day07.interfaceExam;

import com.example.day07.Circle;
import com.example.day07.Drawable;
import com.example.day07.Figure;

public class InstanceOf {
    public static void main(String[] args) {
        Circle c = new Circle(1);
        System.out.println(c instanceof Circle);
        System.out.println(c instanceof Drawable);
        System.out.println(c instanceof Figure);
    }
}
