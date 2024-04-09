package com.example.day07.interfaceExam;

public interface Animal {
    int age = 1; // 인터페이스에서 사용하는 변수는 상수로 취급된다.
    // static final 생략되어있다.
    public void speak();
}
