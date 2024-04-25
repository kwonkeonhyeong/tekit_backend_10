package com.example.day16;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RamdaExam01 {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple","banana","charry");

        Consumer<String> ramdaTest = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        items.forEach(e-> System.out.println(e));
        items.forEach(ramdaTest);
        items.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread start!!");
            }
        }).start();

        new Thread( () -> System.out.println("Thread.start")).start();
    }
}
