package com.example.day12;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutExam {
    public static void main(String[] args) {
        // 원시 데이터 타입으로 파일에 쓰고 싶다.
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
                ) {
            dos.writeBoolean(true);
            dos.writeByte(Byte.MAX_VALUE);
            dos.writeChar('H');
            dos.writeInt(10);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
