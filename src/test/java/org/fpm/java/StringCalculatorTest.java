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
        assertEquals(3, calculate.add("1,\n2"));
    }
    @Test
    public void several_numbers(){
        StringCalculator calculate = new StringCalculator();
        assertEquals(6, calculate.add("1,2,3"));
        assertEquals(42, calculate.add("1,2,30,4,5"));
    }
    @Test
    public void newline_character_and_comma(){
        StringCalculator calculate = new StringCalculator();
        assertEquals(6, calculate.add("1\n2\n3"));
        assertEquals(80, calculate.add("1,2\n32\n40,5"));
    }
    @Test
    public void user_defined_delimiter(){
        StringCalculator calculate = new StringCalculator();
        assertEquals(6, calculate.add("//[!]\n1!2!3"));
        assertEquals(47, calculate.add("//[;]\n1;2;35;4;5"));
        assertEquals(47, calculate.add("//[*]\n1*2*35*4*5"));
    }
    @Test
    public void negative_number_exception_handling(){
        StringCalculator calculate = new StringCalculator();
        try {
            calculate.add("//[*]\n1*-2*35*-4*-5");
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
            System.out.println("Negative number exception was processed.\n");

        }

    }
}
