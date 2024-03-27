package com.example.day06;

public class Test3 {
    public static void main(String[] args) {
        // 부모는 자식을 가리킬 수 있다.
        // 조상은 자손을 가리킬 수 있다.
        Parent p = new Child();
        Object obj = new Child();
        Object obj2 = new Parent();

        System.out.println(((Child)obj).i);
    }
}
