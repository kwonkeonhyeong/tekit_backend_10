package com.example.day08.exceptionhandling;

public class ExceptionExam01 {
    public static void main(String[] args) {
        int[] iarr = {1,2,3};
        try {
//            int result = 10/0;
            System.out.println(iarr[3]);
            System.out.println("거울을 본다.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println(iarr[0]);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("다음문장1");
        System.out.println("다음문장2");
        System.out.println("다음문장3");
        System.out.println("end!!");
    }
}
