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
    @Test
    public void several_numbers(){
        StringCalculator calculate = new StringCalculator();
        assertEquals(6, calculate.add("1,2,3"));
        assertEquals(15, calculate.add("1,2,3,4,5"));
    }
    @Test
    public void newline_character_and_comma(){
        StringCalculator calculate = new StringCalculator();
        assertEquals(6, calculate.add("1\n2\n3"));
        assertEquals(15, calculate.add("1,2\n3\n4,5"));
    }
}
