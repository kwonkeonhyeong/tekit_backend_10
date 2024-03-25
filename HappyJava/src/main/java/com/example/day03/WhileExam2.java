package com.example.day03;

public class WhileExam2 {
    public static void main(String[] args) {
        int num=1;
        while(true) {
            System.out.println(num++);
            if(num == 5) {
                break;
            }
        }
    }
}
