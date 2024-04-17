package com.example.day12.exam2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TextFileManager {
    private final String filePath;

    public TextFileManager(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(List<String> userInput) {
        try (
            PrintWriter writer = new PrintWriter(filePath);
                )
        {
            for (String str : userInput) {
                writer.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFromFile() throws IOException {
        List<String> outputData = new ArrayList<>();
        try (
                BufferedReader reader =new BufferedReader(new FileReader(filePath));
                )
        {
            String str;
            while((str = reader.readLine()) != null) {
                outputData.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputData;
    }
}
