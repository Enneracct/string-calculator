package org.fpm.java;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        // Check if the string is null or empty
        if ((numbers == null) || numbers.isEmpty()) return 0;
        else if (numbers.length()==1) return Integer.parseInt(numbers);

        // Default delimiters: comma and newline character
        String delimiter = "[,\\s]+";
        String numbersString = numbers;

        // Check if method's argument has user-defined delimiter, then  substring the string
        if (numbers.startsWith("//")) {
            int delimiterStartIndex = numbers.indexOf("[") + 1;
            int delimiterEndIndex = numbers.indexOf("]");
            String delimiterString = numbers.substring(delimiterStartIndex, delimiterEndIndex);
            delimiter = Pattern.quote(delimiterString);
            numbersString = numbers.substring(numbers.indexOf("\n") + 1);
        }

        // Splitting the string using the delimiter
        String[] numArr = numbersString.split(delimiter);

        // Creating an array to store parsed integers
        int[] parsedNumbers = new int[numArr.length];

        // The result variable that stores sum of parsed integers
        int result = 0;

        for (int i = 0; i < numArr.length; i++) {
            // Parsing each string number to int
            parsedNumbers[i] = Integer.parseInt(numArr[i]);
            result += parsedNumbers[i];
        }

        return result;
    }
}