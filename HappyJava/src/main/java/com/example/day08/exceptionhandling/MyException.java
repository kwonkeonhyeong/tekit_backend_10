package com.example.day08.exceptionhandling;

public class MyException extends RuntimeException {

    public MyException(String msg) {
        super(msg);
    }
    public MyException() {
        super("점수는 0-100까지만 입력 받을 수 있습니다.");
    }
}
