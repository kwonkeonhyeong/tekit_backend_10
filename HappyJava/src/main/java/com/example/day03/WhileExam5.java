package com.example.day03;

public class WhileExam5 {
    public static void main(String[] args) {
        int num=1;
        int total=0;

        while(num<=100){
            if(num%2==0){
                total+=num;
            }
            num++;
        }
        System.out.println(total);
    }
}
