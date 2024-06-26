package com.example.day10;

public class SpecialBox<T> extends Box2<T> {
    public SpecialBox(T content) {
        super(content);
    }

    public void printContent() {
        System.out.println("Special box contains: " + getContent());
    }

    public static void main(String[] args) {
        SpecialBox<String> specialBox = new SpecialBox<>("phone");
        specialBox.printContent();
    }
}
