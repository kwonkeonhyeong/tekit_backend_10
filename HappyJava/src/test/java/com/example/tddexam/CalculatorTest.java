package com.example.tddexam;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        System.out.println("각 테스트 메서드가 실행되기 전에 실행.  모든 테스트 메스드마다 실행!!");
        calculator = new Calculator();
    }
    @BeforeAll
    static void beforeAll() {
        System.out.println("테스트 클래스가 실행될 때 한 번 실행됨.");
    }

    @AfterEach
    void afterEach() {
        System.out.println("각 테스트 메소드가 실행 된 후 실행!!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("모든 테스트가 종료된 후 실행!!");
    }

    @Test
    void 숫자_합() {
        assertEquals(4,calculator.plus(1,3));
        assertThat(calculator.plus(1,3)).isEqualTo(4);
    }

    @Test
    void 숫자_차() {
        assertEquals(4, calculator.minus(5,1));
        assertThat(calculator.minus(5,1)).isEqualTo(4);
    }

}