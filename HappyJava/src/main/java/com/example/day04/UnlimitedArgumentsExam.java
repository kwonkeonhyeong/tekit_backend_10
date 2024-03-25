package com.example.day04;

public class UnlimitedArgumentsExam {
    public static void main(String[] args) {
        System.out.println(sum(5,10));
        System.out.println(sum(1,2,3,4,5,10));
        System.out.println(sum(3,65,4,3,1,5,10));
    }
    public static int sum(int... args) {
        System.out.println("print1 메소드 - args 길이 : " + args.length);
        int sum = 0;
        for(int i = 0; i < args.length; i++){
            sum += args[i];
        }
        return sum;

    }
}
