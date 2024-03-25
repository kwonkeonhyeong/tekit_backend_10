package com.example.day03;

public class Gugudan1 {
    public static void main(String[] args) {
        for(int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
//                System.out.print(j + " * " + i + " = " + (i*j) + "\t");
                System.out.printf("%d * %d = %d\t",j,i,j*i);
                if(j == 5)
                    break;
            }
            System.out.println();
        }
    }
}
