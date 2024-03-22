package ch05;

import java.util.Scanner;

public class RecursiveExploration {
    static void displayPattern(int n) {
        if(n > 0) {
            displayPattern(n - 1);
            System.out.println("Number: " + n);
            displayPattern(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("출력할 숫자를 입력하세요: ");
        int x = scanner.nextInt();

        displayPattern(x);
    }
}
