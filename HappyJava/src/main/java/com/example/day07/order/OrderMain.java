package com.example.day07.order;

public class OrderMain {
    public static void main(String[] args) {
        // 피자 주문 및 신용카드 결제 시뮬레이션
        Order pizzaOrder = new PizzaOrder();
        pizzaOrder.completeOrder();
        Payment creditPayment = new CreditPayment();
        creditPayment.processPayment();

        // 버거 주문 및 현금 결제 시뮬레이션
        Order burgerOrder = new BurgerOrder();
        burgerOrder.completeOrder();
        Payment cashPayment = new CashPayment();
        cashPayment.processPayment();


    }
}
