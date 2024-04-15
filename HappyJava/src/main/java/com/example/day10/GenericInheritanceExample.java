package com.example.day10;

public class GenericInheritanceExample {
    public static void main(String[] args) {
        SpecialBox<String> specialBox = new SpecialBox<>("Hello world!!");
        specialBox.printContent();

        ColoredBox<String, String> coloredBox = new ColoredBox<>("Hello World","Red");
        System.out.println(coloredBox);
    }
}
