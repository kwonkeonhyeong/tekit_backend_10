package com.example.day07;

public class MyCalculator implements Calculator {

    @Override
    public int plus(int i, int j) {
        System.out.println("구현부 plus");
        return i+j;
    }

    @Override
    public int multiple(int i, int j) {
        System.out.println("구현부 multiple");
        return i*j;
    }

    public void who() {
        System.out.println("여기는 구현부입니다.");
    }
}
