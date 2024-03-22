package exam;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("윷을 몇 번 던질건가요? ");
        int count = scanner.nextInt();

        int[][] totalThrowYut = throwYut(count);

        printTotalThrow(totalThrowYut);

        for (int[] ints : totalThrowYut) {
            whatIsYoot(yootSum(ints));
            System.out.print("\t");
        }
    }

    static void printTotalThrow(int[][] totalThrowsResult) {
        for (int i = 0; i < totalThrowsResult.length; i++) {
            System.out.println(i+1 +"번째 윷 결과: " + Arrays.toString(totalThrowsResult[i]));
        }
    }

    static public int[][] throwYut(int count) {
        Random random = new Random();
        int[][] totalThrowsResult = new int[count][];

        for (int i = 0; i < count; i++) {
            int[] yut = new int[4];
            for (int j = 0; j < yut.length; j++) {
                yut[j] = random.nextInt(2);
            }
            totalThrowsResult[i] = yut;
        }
        return totalThrowsResult;
    }
    static int yootSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length ; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    static void whatIsYoot(int sum) {
        if (sum==0) {
            System.out.print("윷");
        } else if (sum == 1) {
            System.out.print("도");
        } else if (sum ==2) {
            System.out.print("개");
        } else if (sum==3) {
            System.out.print("걸");
        } else
            System.out.print("모");
    }
}
