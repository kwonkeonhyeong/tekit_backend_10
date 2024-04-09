package com.example.day07.order;

public class CreditPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("카드로 결제합니다.");
    }
}
