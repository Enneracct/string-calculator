package org.fpm.java;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

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

        List<Integer> negativeNumbers = new ArrayList<>(); // Creating a list to store negative numbers

        int result = 0;

        for (String number : numArr) {
            int parsedNumber = Integer.parseInt(number);

            if (parsedNumber < 0) {
                negativeNumbers.add(parsedNumber); // Storing negative numbers
            }

            result += parsedNumber;
        }
        if (!negativeNumbers.isEmpty()) {
            String message = "\nParsed negative numbers: " + negativeNumbers;
            throw new NumberFormatException(message);
        }

        return result;
    }
}