package com.example.day07.order;

public class BurgerOrder extends Order {
    @Override
    protected void serveFood() {
        System.out.println("햄버거가 나왔습니다.");
    }

    @Override
    protected void prepareFood() {
        System.out.println("햄버거를 준비 중입니다.");
    }
}
