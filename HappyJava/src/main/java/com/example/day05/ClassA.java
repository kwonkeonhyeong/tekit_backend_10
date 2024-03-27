package com.example.day05;

public class ClassA {
    public static String fieldA = "fieldA"; // 클래스 필드
    public String fieldB = "fieldB"; // 인스턴스 필드

    int count;
    protected  int number;
    private  String address;
    public String name;

    public static void main(String[] args) {
        System.out.println(ClassA.fieldA);
        ClassA a = new ClassA();
        System.out.println(a.fieldB);
        System.out.println(a.count);
        System.out.println(a.number);
        System.out.println(a.address);
        System.out.println(a.name);
    }
}
