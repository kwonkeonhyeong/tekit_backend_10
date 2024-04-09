package com.example.day07;

public class Test {
    public static void main(String[] args) {
        Child child = new Child();
//        String name = child.getName();
//        System.out.println(name);
        System.out.println(child);
        System.out.println(child.toString());

        String str = "hello";
        System.out.println(str);
        System.out.println(str.toString());

        Product pen1 = new Product("검정팬", 3000);
        System.out.println(pen1.toString());

        Product pen2 = new Product("검정팬", 2950);

        if(pen1 == pen2) {
            System.out.println("같아요.");
        } else {
            System.out.println("달라요.");
        }

        if(pen1.equals(pen2)) {
            System.out.println("같아요.");
        } else {
            System.out.println("달라요.");
        }
    }
}
