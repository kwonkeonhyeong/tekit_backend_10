package com.example.day17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExam {
    public static void main(String[] args) {
        List<Member> memberList = Arrays.asList(
                new Member("kang",31,Member.FEMALE),
                new Member("kim",27,Member.MALE),
                new Member("lee",78,Member.FEMALE),
                new Member("hong",28,Member.MALE),
                new Member("kwon",41,Member.FEMALE)
        );

        Map<Integer, List<Member>> mapBySex = memberList.stream().collect(Collectors.groupingBy(Member::getSex));
        System.out.println(mapBySex);
        mapBySex.get(Member.MALE).stream().forEach(member -> System.out.println(member.getName()));
        System.out.println("================================================");
        mapBySex.get(Member.FEMALE).stream().forEach(member -> System.out.println(member.getName()));
    }
}
