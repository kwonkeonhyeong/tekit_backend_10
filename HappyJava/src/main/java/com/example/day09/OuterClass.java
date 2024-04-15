package com.example.day09;

import java.awt.desktop.OpenURIEvent;

public class OuterClass {
    private int outerFiled = 10;
    private InnerClass innerClass;

    public void outerMethod() {
        InnerClass inner = new InnerClass();
        inner.innerMethod();
    }

    class InnerClass {
        public void innerMethod() {
            System.out.println("outerFiled = " + outerFiled);
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outerMethod();
    }
}
