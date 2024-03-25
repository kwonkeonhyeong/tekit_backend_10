package com.example.tddexam;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateCalculatorTest {
    private DateCalculator dateCalculator;

    @BeforeEach
    void beforeEach() {
        dateCalculator = new DateCalculator();
    }

    @Test
    void calculateAge() {
        LocalDate brithDate = LocalDate.of(1996,2,16);
        LocalDate currentDate = LocalDate.now();

        Assertions.assertEquals(28,dateCalculator.calculateAge(brithDate,currentDate));
    }

    @Test
    void calculateDay() {
        LocalDate startDate = LocalDate.of(2024, 3, 15);
        LocalDate endDate = LocalDate.of(2024,3,18);

        Assertions.assertEquals(3,DateCalculator.calculateDay(startDate,endDate));
    }

}
