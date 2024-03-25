package com.example.day02;

public class PrimitiveCastExam1 {
    public static void main(String[] args) {
        byte b = 10;
        int i = b; // 묵시적 형변환

        b = (byte) i; // 명시적 형변환

        int i1 = (int) 50.0;
    }
}
