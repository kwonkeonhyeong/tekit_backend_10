package exam;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = new int[28];
        int[] result = new int[2];

        for (int i = 0; i < 30; i++) {
            int number = scanner.nextInt();
        }

        Arrays.sort(input);

        int inputIndex = 0;
        int resultIndex = 0;

        for (int i = 0; i < 30; i++) {
            if(input[inputIndex] == i+1) {
                inputIndex++;
                continue;
            }
            result[resultIndex++] = i+1;
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
