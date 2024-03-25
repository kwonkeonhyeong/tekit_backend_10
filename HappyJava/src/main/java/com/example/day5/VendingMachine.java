package com.example.day5;

public class VendingMachine {

    public static void printVersion() {
        System.out.println("자판기 v0.1");
    }

    public String pushProductButton(int i) {
        if(i == 1) {
            return "콜라";
        } else {
            return "사이다";
        }
    }
}
