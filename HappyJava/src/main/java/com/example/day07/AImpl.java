package com.example.day07;

public class AImpl implements AInter{
    @Override
    public void aMethod() {
        System.out.println("aMethod를 AImpl에서 구현함");
    }

    @Override
    public void same() {
        System.out.println("same를 AImpl에서 구현함");
    }

    public void say() {
        System.out.println("Aimpl이 가진 메소드");
    }
}
