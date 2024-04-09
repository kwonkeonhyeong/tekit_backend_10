package com.example.day07.order;

public class CashPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("현금으로 결제합니다.");
    }
}
