package com.example.day11;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PhoneBookExample {
    public static void main(String[] args) {
        // HashMap 생성
        Map<String, String> phoneBook = new HashMap<>();

        // 전화번호 추가
        phoneBook.put("김철수", "010-1234-5436");
        phoneBook.put("이민지", "010-1314-1946");
        phoneBook.put("박홍수", "010-5334-5326");
        phoneBook.put("소명기", "010-9285-8234");

        // 특정 키를 이용해 전화번호 검색
        String minjiNumber = phoneBook.get("이민지");
        System.out.println("이민지의 전화번호: " + minjiNumber);

        // 전체 전화번호 목록 출력
        System.out.println("전체 전화번호 목록: ");
        for (Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 데이터 삭제
        phoneBook.remove("이민지");
        System.out.println("전체 전화번호 목록: ");
        for (Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 특정 키 존재 여부 확인
        if(phoneBook.containsKey("소명기")) {
            System.out.println("존재해요.");
        }

        // 특정 값 존재 여부 확인
        if(phoneBook.containsValue("010-5334-5326")) {
            System.out.println("존재해요.");
        }

        //Map이 비었는지 확인
        System.out.println("비었어요?" + phoneBook.isEmpty());

        //Map 크기 확인
        System.out.println(phoneBook.size());
    }
}
