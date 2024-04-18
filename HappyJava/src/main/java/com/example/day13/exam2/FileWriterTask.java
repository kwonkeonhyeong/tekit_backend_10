package com.example.day13.exam2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterTask implements Runnable {
    @Override
    public void run() {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                FileOutputStream writer = new FileOutputStream("output.txt");
        ) {
            String data;
            while(!(data = reader.readLine()).isEmpty()) {
                data = data + "\n";
                writer.write(data.getBytes());
            }
        } catch (IOException e) {}
    }
}
