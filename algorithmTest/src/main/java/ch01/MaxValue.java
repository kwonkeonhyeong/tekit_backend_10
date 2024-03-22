package ch01;

public class MaxValue {
    // 메소드
    // 접근제한자 리턴타입 메소드명 (매개변수들...) {}
    public static int max(int a, int b, int c) {
        // 두 숫자를 비교해서 더 큰 수를 찾아낸다.
        // 더 큰 수를 다음 수와 비교해서 더 큰 수를 찾아낸다.
        // 내 답안
        // return Math.max(Math.max(a,b),c);
        int max = a;
        if(b > max) {
            max = b;
        }
        if(c > max) {
            max = c;
        }
        return max;
    }
    // main
    public static void main(String[] args) {
        int a = 34;
        int b = 78;
        int c = 56;

        int result = max(a,b,c);
        System.out.println("최댓값: " + result);
    }
}
