package com.example.day09;

import com.example.day09.OuterClass.InnerClass;

public class StaticOuterClass {
    private static int outerFiled = 10;

    public void outerMethod() {

    }

    static class InnerClass {
        public void innerMethod() {
            System.out.println("outerFiled = " + outerFiled);
        }
    }

    public static void main(String[] args) {

    }
}
