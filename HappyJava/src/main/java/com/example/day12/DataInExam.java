package com.example.day12;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInExam {
    public static void main(String[] args) {
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
                ) {
            System.out.println("boolean: "+dis.readBoolean());
            System.out.println("byte: "+dis.readByte());
            System.out.println("char: "+dis.readChar());
            System.out.println("int: "+dis.readInt());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
