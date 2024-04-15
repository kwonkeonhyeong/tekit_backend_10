package com.example.day08.exceptionhandling;

public class ExceptionExam02 {
    public static void main(String[] args) {
        System.out.println("프로그램 시작!!");

        try {
            int i = Integer.parseInt(args[0]);
            System.out.println(10/i);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("프로그램 종료");
    }
}
