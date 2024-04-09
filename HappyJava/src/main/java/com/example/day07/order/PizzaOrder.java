package com.example.day07.order;

public class PizzaOrder extends Order {
    @Override
    protected void serveFood() {
        System.out.println("피자가 나왔습니다.");
    }

    @Override
    protected void prepareFood() {
        System.out.println("피자를 준비 중입니다.");
    }
}
