package com.example.day04;

public class Array04 {
    public static void main(String[] args) {
//        ItemForArray[] array1 = new ItemForArray[5];
        ItemForArray array2[];
        array2 = new ItemForArray[5];

//        array1[0] = new ItemForArray(1000, "펜");
//        array1[1] = new ItemForArray(2000, "지우개");
//        array1[2] = new ItemForArray(3000, "샤프");
//        array1[3] = new ItemForArray(4000, "화이트");
//        array1[4] = new ItemForArray(5000, "USB");
//
//        for (int i = 0; i < array1.length; i++) {
//            System.out.print( "name = " + array1[i].getName() + "\t");
//            System.out.println("price = " + array1[i].getPrice());
//        }
//
//        ItemForArray[] array3 = new ItemForArray[]{new ItemForArray(100, "a"),new ItemForArray(200, "b")};
//        ItemForArray[] array4 = {new ItemForArray(100, "a"),new ItemForArray(200, "b")};
//
//        for (int i = 0; i < args.length; i++) {
//            System.out.print(args[i] + " ");
//        }

        for (int i=0;i<array2.length;i++){
            array2[i]= new ItemForArray(500,"사과");
        }

        for (ItemForArray array : array2) {
            System.out.println(array);
            System.out.println(array.getName());
            System.out.println(array.getPrice());
        }
    }
}
