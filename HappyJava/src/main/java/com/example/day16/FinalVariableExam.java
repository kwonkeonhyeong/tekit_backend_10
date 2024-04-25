package com.example.day16;

import org.w3c.dom.ls.LSOutput;

public class FinalVariableExam {
    public static void main(String[] args) {
        int x = 10;
        System.out.println("람다에서 파이널로 사용.");

        Runnable r = () -> {
            System.out.println("x : "+ x);
        };

//        x = 20; // 사실상 final 때문에 x 변경 불가능
        r.run();
    }
}
