package com.example.day10;

public class GenericMethodExample2 {
    public static <T extends Number> T max(T x, T y, T z) {
        T max = x;
        if(y.doubleValue() > max.doubleValue()) {
            max = y;
        }
        if(z.doubleValue() > max.doubleValue()) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(max(1,3,4));
        System.out.println(max(5.3,3.2,6.9));
        // System.out.println("ab","ccc","dk2"); 캄파일 에러 발생!!!
    }
}
