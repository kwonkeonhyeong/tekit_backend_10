package com.example.day09;

public class LocalOuterClass {
    private int outerField = 10;

    public void outerMethod() {
        class InnerClass {
            public void innerMethod() {
                System.out.println("outerField = " + outerField);
            }
        }

        InnerClass innerClass = new InnerClass();
        innerClass.innerMethod();
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.outerMethod();
    }
}
