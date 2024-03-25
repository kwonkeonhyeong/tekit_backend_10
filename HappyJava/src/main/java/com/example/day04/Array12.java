package com.example.day04;

public class Array12 {
    public static void main(String[] args) {
        int[] iarr = {10,20,30,40};

        // for each 문

        for(int i:iarr) {
            System.out.println(i);
        }

        for (int i = 0; i < iarr.length; i++) {
            int v = iarr[i];
            System.out.println(v);
        }

        // 인덱스로 접근해서 인스턴스를 실체화 해야 하는데 인덱스로 접근을 못해서 실체화가 안된다.
        ItemForArray[] items = new ItemForArray[4];
        for (ItemForArray item : items) {
            item = new ItemForArray(1000,"pen");
        }
    }
}
