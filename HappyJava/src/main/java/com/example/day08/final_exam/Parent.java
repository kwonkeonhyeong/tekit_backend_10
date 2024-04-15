package com.example.day08.final_exam;

public class Parent {
    public final void print() {
        System.out.println("parent");
    }
}

class Child extends Parent {
    // final은 오버라이딩 할 수 없다!
}
