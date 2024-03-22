package ch05;

public class GCDCalculator {
    static int calculatorGCD(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return calculatorGCD(y, x%y);
        }
    }

    static int gcd(int x,int y) {
        while(y != 0) {
            int temp = y;
            y = x%y;
            x = temp;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(calculatorGCD(1071, 462));
        System.out.println(gcd(1071, 462));
    }
}
