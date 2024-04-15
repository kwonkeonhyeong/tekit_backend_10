package com.example.day09;

public class StringMain {
    public static void main(String[] args) {
        String greeting = "Hello World!";
        System.out.println("문자열 길이: " + greeting.length());
        System.out.println("5번째 문자: " + greeting.charAt(4));
        System.out.println("부분 문자열: " + greeting.substring(7,12));
    }
}
