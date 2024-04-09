package exam;

import java.util.Scanner;

public class Taxi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int raceTime = scanner.nextInt();
        int raceDistance = scanner.nextInt();

        System.out.println(feeCalculator(raceTime, raceDistance));

    }

    public static int feeCalculator(int time, int distance) {
        int kmFee = 0;
        int secondFee = 0;
        if (time-600 > 0) {
            secondFee = (time-600) * 2;
        }
        if (distance-8 > 0) {
            kmFee = (distance-8) * 210;
        }
        return 410 + kmFee + secondFee;
    }
}
