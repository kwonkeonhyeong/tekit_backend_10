package com.example.babylion.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Exam02 {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
                ) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
