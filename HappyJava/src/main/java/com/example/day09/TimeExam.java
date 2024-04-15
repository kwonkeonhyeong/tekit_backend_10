package com.example.day09;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeExam {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("date = " + date);
        System.out.println("time = " + time);
        System.out.println("dateTime = " + dateTime);

        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("현재 날짜와 시간(시간대 포함): " + now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("포맷팅된 날짜와 시간: " + now.format(formatter));


    }
}
