package com.example.day07.interfaceExam;

public class Dog implements Animal {
    int age1 = 20;
    @Override
    public void speak() {
        System.out.println("바우와우");
    }
}
