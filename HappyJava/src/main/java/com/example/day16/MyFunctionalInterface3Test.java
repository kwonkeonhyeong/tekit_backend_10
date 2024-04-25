package com.example.day16;

public class MyFunctionalInterface3Test {
    public static void main(String[] args) {
        MyFunctionalInterface3 fi3;

        fi3 = new MyFunctionalInterface3() {
            @Override
            public int method(int x, int y) {
                return y;
            }
        };
        System.out.println(fi3.method(5,123123));

        fi3 = (int x, int y) -> {return y;};
        System.out.println(fi3.method(5,98));


    }
}
