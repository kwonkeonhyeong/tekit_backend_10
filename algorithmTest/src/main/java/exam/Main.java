package exam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int V = scanner.nextInt();

        double result = (double)(V-B)/(A-B);
        System.out.println((int) Math.ceil(result));
    }
}
