package com.example.day17;

import java.util.Arrays;
import java.util.List;

public class ReduceExam1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = numbers.stream().reduce(0,(a,b) -> a + b);
        System.out.println(sum);

        List<Member> memberList = Arrays.asList(
                new Member("kim",90),
                new Member("han",100),
                new Member("oh",70),
                new Member("lee",80),
                new Member("min",65)
        );

        // Member들의 score 총합을 구해봅시다.
        int memberScoreSum = memberList.stream().mapToInt(Member::getScore).reduce(0,(a,b) -> a + b);
        System.out.println(memberScoreSum);
        int memberScoreSum2 = memberList.stream().mapToInt(Member::getScore).reduce((a,b) -> a + b).getAsInt();
        System.out.println(memberScoreSum2);
        int memberScoreSum3 = memberList.stream().mapToInt(Member::getScore).sum();
        System.out.println(memberScoreSum3);
        int memberScoreSum4 = memberList.stream().mapToInt(Member::getScore).reduce(0,Integer::max);
        System.out.println(memberScoreSum4);


    }
}
