package com.example.day16;

public class MyFunctionalInterfaceTest {
    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface;
        MyFunctionalInterface myFunctionalInterface1;
        MyFunctionalInterface myFunctionalInterface2;

        myFunctionalInterface = new MyFunctionalInterface() {
            @Override
            public void method1() {
                System.out.println("method 1 call");
            }

//            @Override
//            public void method2() {
//                System.out.println("method 2 call");
//            }
        };

        myFunctionalInterface.method1();
//        myFunctionalInterface.method2();
        myFunctionalInterface1 = new MyFunctionalInterface() {
            @Override
            public void method1() {
                System.out.println("fdsf");
            }
        };


        myFunctionalInterface = () -> System.out.println("hello");

        myFunctionalInterface1.method1();
        myFunctionalInterface.method1();
    }
}
