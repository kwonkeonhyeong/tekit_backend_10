package com.example.day12;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DatatypesIoExample {
    public static void main(String[] args) {
        // 입출력되는 데이터는 모두 바이트거나 캐릭터로 전송되는...
        // 자바의 데이터타입으로 읽고 쓰고 싶다. // DataInputStream...
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("data2.bin"));
                DataInputStream dis = new DataInputStream(new FileInputStream("data2.bin"))
                ) {
            dos.writeInt(123);
            dos.writeDouble(123.45);
            dos.writeBoolean(true);
            dos.writeUTF("Hello world!");

            int intData = dis.readInt();
            Double doubleData = dis.readDouble();
            Boolean booleanData = dis.readBoolean();
            String stringData = dis.readUTF();

            System.out.println("intData = " + intData);
            System.out.println("doubleData = " + doubleData);
            System.out.println("booleanData = " + booleanData);
            System.out.println("stringData = " + stringData);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

