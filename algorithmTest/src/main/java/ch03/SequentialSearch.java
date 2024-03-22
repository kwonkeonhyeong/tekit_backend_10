package ch03;

import java.util.Arrays;

public class SequentialSearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,33,45,2,3,13};
        int index = sequentialSearch(arr, 3);

        if(index != -1) {
            System.out.println("당신이 찾는 데이터는 " + index + "번째 인덱스에 있습니다.");
        } else {
            System.out.println("당신이 찾는 데이터는 존재하지 않습니다.");
        }

        Arrays.sort(arr);
        int binaryIndex = binarySearch(arr ,33);
        if(binaryIndex != -1) {
            System.out.println("당신이 찾는 데이터는 " + binaryIndex + "번째 인덱스에 있습니다.");
        } else {
            System.out.println("당신이 찾는 데이터는 존재하지 않습니다.");
        }

    }

    static int binarySearch(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;

        while(start < end) {
            int mid = (start+end)/2;
            if(array[mid] == key) {
                return mid;
            }
            if(array[mid] > key) {
                end = mid - 1;
            } else if (array[mid] < key) {
                start = mid + 1;
            }
        }
        return -1;
    }

//    static int binarySearch(int[] array, int key) {
//        int startIndex = 0;
//        int endIndex = array.length - 1;
//
//        while(startIndex < endIndex) {
//            int medianIndex = (startIndex + endIndex) / 2;
//            if(array[medianIndex] == key) {
//                return medianIndex;
//            }
//            if(array[medianIndex] > key) {
//                endIndex = medianIndex -1;
//            } else {
//                startIndex = medianIndex + 1;
//            }
//        }
//        return -1;
//    }

    static int sequentialSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == key) {
                return i;
            }
        }
            return -1;
    }
}
