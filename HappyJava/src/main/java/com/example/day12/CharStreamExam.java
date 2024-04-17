package com.example.day12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamExam {
    public static void main(String[] args) {
        try(
                FileReader reader = new FileReader("a.txt");
                FileWriter writer = new FileWriter("c.txt");
                ) {
            int c;
             while((c = reader.read()) != -1) {
                 System.out.println((char)c);
                 writer.write(c);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
