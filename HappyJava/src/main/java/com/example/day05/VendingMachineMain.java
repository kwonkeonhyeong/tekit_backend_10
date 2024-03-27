package com.example.day05;

public class VendingMachineMain {
    public static void main(String[] args) {
        VendingMachine.printVersion(); // 클래서 메서드

        VendingMachine vendingMachine = new VendingMachine();
        String product = vendingMachine.pushProductButton(2); // 인스턴스 메서드
        System.out.println(product);
    }
}
