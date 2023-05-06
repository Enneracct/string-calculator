package org.fpm.java;

public class StringCalculator {
    public int add(String numbers) {
        // Check if the string is null or empty
        if ((numbers == null) || numbers.isEmpty()) return 0;
        else if (numbers.length()==1) return Integer.parseInt(numbers);

        // Split the string by comma separator
        String[] numArr = numbers.split(",");

        int[] parsedNumbers = new int[numArr.length];

        int result = 0;

        for (int i = 0; i < numArr.length; i++){
               parsedNumbers[i] = Integer.parseInt(numArr[i]);
               result += parsedNumbers[i];
        }

        return result;
    }
}