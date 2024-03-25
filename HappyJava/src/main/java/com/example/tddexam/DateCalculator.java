package com.example.tddexam;

import java.time.LocalDate;

public class DateCalculator {
    public static int calculateDay(LocalDate startDate, LocalDate endDate) {
        return startDate.until(endDate).getDays();
    }

    public int calculateAge(LocalDate brithDate, LocalDate currentDate) {
        return currentDate.getYear() - brithDate.getYear();
    }
}
