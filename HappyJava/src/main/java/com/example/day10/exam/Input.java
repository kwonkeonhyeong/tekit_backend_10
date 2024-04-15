package com.example.day10.exam;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public int inputNumber() {
        return scanner.nextInt();
    }
}
