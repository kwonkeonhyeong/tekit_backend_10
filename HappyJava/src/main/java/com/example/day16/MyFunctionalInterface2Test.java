package com.example.day16;

public class MyFunctionalInterface2Test {
    public static void main(String[] args) {
        MyFunctionalInterface2 fi2;

        fi2 = new MyFunctionalInterface2() {
            @Override
            public void method(int x) {
                int result = x * 5;
                System.out.println(result);
            }
        };
        fi2.method(13);

        fi2 = x -> {
            int result = x * 5;
            System.out.println(result);
        };
        fi2.method(124);
    }
}
