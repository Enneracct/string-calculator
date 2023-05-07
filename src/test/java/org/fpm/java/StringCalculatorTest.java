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
        assertEquals(47, calculate.add("//[***]\n1***2***35***4***5"));
    }
    @Test
    public void negative_number_exception_handling(){
        StringCalculator calculate = new StringCalculator();
        try {
            calculate.add("//[*]\n1*-2*35*-4*-5");
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("negative_number_exception_handling test was processed.\n");
        }
    }
    @Test
    public void big_integers(){
        StringCalculator calculate = new StringCalculator();
        assertEquals(6, calculate.add("1\n2\n3\n1001"));
        assertEquals(1003, calculate.add("1,2,1000"));
    }
    @Test
    public void multiple_user_defined_delimiters(){
        StringCalculator calculate = new StringCalculator();
        assertEquals(47, calculate.add("//[***][%]\n1***2%35***4%5"));
        assertEquals(12, calculate.add("//[!!!][%][&]\n1!!!2%3555&4%5"));
    }
    @Test
    public void input_string_starts_with_delimiter() {
        StringCalculator calculate = new StringCalculator();
        try {
            calculate.add(",1,2,3");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("input_string_starts_with_delimiter test was processed.\n");
        }
    }
}
