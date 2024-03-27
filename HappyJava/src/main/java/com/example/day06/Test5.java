package com.example.day06;

public class Test5 {
    public static void main(String[] args) {
        Parent p = new Parent();
        System.out.println(p.i);
        System.out.println(p.getI());

        Child c = new Child();
        System.out.println(c.i);
        System.out.println(c.getI());

        // 2. 필드는 타입을 따른다.
        // 3. 메소드는 무조건 !!! 자식을 따른다.... (다형성)
        Parent pc = new Child();
        System.out.println(pc.i);
        System.out.println(pc.getI());


    }
}
