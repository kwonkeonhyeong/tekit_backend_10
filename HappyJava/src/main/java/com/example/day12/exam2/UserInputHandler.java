package com.example.day12.exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputHandler {
    public List<String> getUserInput() {
        List<String> userInput = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String text;
        while(!(text = scanner.nextLine()).isEmpty()) {
            System.out.println(text);
            userInput.add(text);
        }
        return userInput;
    }
}
