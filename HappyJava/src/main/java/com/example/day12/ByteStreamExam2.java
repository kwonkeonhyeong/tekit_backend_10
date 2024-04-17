package com.example.day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExam2 {
    public static void main(String[] args) {
        // Closeable이라는 인터페이스를 구현하고 있는 리소스는 아래와 같은 방식으로 예외처리가 가능하다!!!
        try (FileInputStream in = new FileInputStream("src\\main\\java\\com\\example\\day12\\ReadFile.java");
             FileOutputStream out = new FileOutputStream("outputFile.txt");) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
