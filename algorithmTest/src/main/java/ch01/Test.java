package ch01;

public class Test {
//    public static void main(String[] args) {
//        int[] arr = {10, 5, 7, 465, 5, 6, 2};
//        int tmp;
//        for (int i = 0; i < arr.length; i++) {
//            if(i == arr.length-1) {
//                break;
//            };
//
//            if (arr[i] > arr[i + 1]) {
//                tmp = arr[i];
//                arr[i] = arr[i + 1];
//                arr[i + 1] = tmp;
//
//            }
//        }
//        for (int i : arr) {
//            System.out.println(i);
//        }
//    }

    public static void main(String[] args) {
        int[] arr = {10,5,7,465,5,6,2};
        int tmp;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
