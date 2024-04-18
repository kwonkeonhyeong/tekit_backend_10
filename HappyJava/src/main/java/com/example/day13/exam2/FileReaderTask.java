package com.example.day13.exam2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTask implements Runnable {
    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
                ) {
            String data;
            while((data = reader.readLine()) != null) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(data);
            }
        } catch (IOException e) {}
    }
}
