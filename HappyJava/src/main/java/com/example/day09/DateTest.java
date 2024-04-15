package com.example.day09;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateTest {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println("현재 날짜와 시간: " + now);

        Date date1 = new Date(2000, 12, 21);
        Date date2 = new Date();
        System.out.println(date1);
        System.out.println(date2);

        if (date2.after(date1)) {
            System.out.println("date2는 date1 이후의 날짜입니다.");
        } else if (date2.before(date1)) {
            System.out.println("date2는 date1 이전의 날짜입니다.");
        }

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "-" + month + "-" + day);

        calendar.set(2020, Calendar.JANUARY, 1);
        int year1 = calendar.get(Calendar.YEAR);
        int month1 = calendar.get(Calendar.MONTH) + 1;
        int day1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year1 + "-" + month1 + "-" + day1);

        calendar.add(Calendar.YEAR, 1);
        calendar.add(Calendar.MONTH, -2);
        int year2 = calendar.get(Calendar.YEAR);
        int month2 = calendar.get(Calendar.MONTH) + 1;
        int day2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year2 + "-" + month2 + "-" + day2);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("년도를 입력하세요.");
        int year3 = keyboard.nextInt();

        System.out.println("월을 입력하세요.");
        int month3 = keyboard.nextInt();

        printCalendar(year, month);
    }

    private static void printCalendar(int year, int month) {
        Calendar calender = Calendar.getInstance();

        calender.set(Calendar.YEAR, year);
        calender.set(Calendar.MONTH, month-1);
        calender.set(Calendar.DAY_OF_MONTH, 1);

        int lastOfDate = calender.getActualMaximum(Calendar.DATE);
        int week = calender.get(Calendar.DAY_OF_WEEK);

        System.out.println("\t\t" + calender.get(Calendar.YEAR) + "년 " + (calender.get(Calendar.MONTH) + 1) + "월");
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        for (int i = 1; i < week; i++) {
            System.out.print("\t");
        }

        for (int i = 1; i <= lastOfDate; i++) {
            System.out.print(i + "\t");
            if(week % 7 == 0) {
                System.out.println();
            }
            week++;
        }
    }
}
