package org.fpm.java;

public class StringCalculator {
    public int add(String numbers) {
        // Check if the string is null or empty
        if ((numbers == null) || numbers.isEmpty()) return 0;
        else if (numbers.length()==1) return Integer.parseInt(numbers);

        // Split the string by comma separator
        String[] numArr = numbers.split(",");


        // Convert the strings to integers and add them together
        int num1 = Integer.parseInt(numArr[0]);
        int num2 = Integer.parseInt(numArr[1]);

        return num1 + num2;
    }
}