package ch02;

public class ListPrimes {
    public static void main(String[] args) {
        for (int num = 2; num <= 1000; num++) {
            boolean isPrime = true;
            for (int divisor = 2; divisor < num; divisor++) {
                if(num % divisor == 0) {
                    isPrime=false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(num);
            }
        }
    }
}
