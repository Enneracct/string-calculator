package org.fpm.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    public void test_empty(){
        StringCalculator calculate = new StringCalculator();
        assertEquals(0, calculate.add(""));
    }
    @Test
    public void test_one_number(){
        StringCalculator calculate = new StringCalculator();
        assertEquals(1, calculate.add("1"));
    }
    @Test
    public void test_two_numbers() {
        StringCalculator calculate = new StringCalculator();
        assertEquals(3, calculate.add("1,2"));
    }

}