package ch01;

import java.util.Scanner;

public class Median {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        System.out.println(med3(100,900,600));

    }
    // 다시 풀기
    static int med3(int a, int b, int c) {
        // 방법1
//        if(a>b) {
//            if(b>c) {
//                return b;
//            }
//
//            if (b <= c) {
//                if(a>c) {
//                    return c;
//                }
//                if(a <= c) {
//                    return a;
//                }
//            }
//        }
//
//        if (a <= b) {
//            if (a > c) {
//                return a;
//            }
//            if ( a <= c ) {
//                if(b < c) {
//                    return b;
//                }
//                if(b >= c) {
//                    return c;
//                }
//            }
//        }
//        return 0;

        // 방법2
//        return Math.min(Math.max(a,b),c);

        // 방법3
        if (a >= b)
            if (b >= c)
                return b;
            else if (a <= c)
                return a;
            else
                return c;
        else if (a > c)
            return a;
        else if (b > c)
            return c;
        else
            return b;
    }
}
