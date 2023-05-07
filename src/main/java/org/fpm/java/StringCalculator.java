package org.fpm.java;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        // Default delimiters: comma and newline character
        String[] delimiters = {",", "\\n"};
        String numbersString;

        // Substring passed string with delimiters if it's needed
        // Pattern.quote() helps us escape metacharacters inside regular expressions
        if (numbers.startsWith("//")) {
            int startIndex = numbers.indexOf("//") + 2;
            int endIndex = numbers.indexOf("\n");
            String delimiterString = numbers.substring(startIndex, endIndex);

            if (delimiterString.startsWith("[")) {
                List<String> delimiterList = new ArrayList<>();
                int start = 0;
                while (true) {
                    int end = delimiterString.indexOf("]", start);
                    if (end == -1) {
                        break;
                    }
                    delimiterList.add(Pattern.quote(delimiterString.substring(start + 1, end)));
                    start = end + 1;
                }
                delimiters = delimiterList.toArray(new String[0]);
            } else {
                delimiters = new String[] {Pattern.quote(delimiterString)};
            }

            numbersString = numbers.substring(numbers.indexOf("\n") + 1);
        } else if ((numbers == null) || numbers.isEmpty()) {return 0;}
        else if (Character.isDigit(numbers.charAt(0))) {
            // If the numbers string starts with a digit, assume the default delimiter
            numbersString = numbers;
        } else {
            throw new IllegalArgumentException("\nUnsupported input format. Digits should be passed in method's argument");
        }
        // Combining the delimiters
        String delimiterPattern = String.join("|", delimiters);

        // Splitting the string using the delimiter
        String[] numArr = numbersString.split(delimiterPattern);

        // Creating a list to store negative numbers
        List<Integer> negativeNumbers = new ArrayList<>();

        // Creating a variable to find sum
        int result = 0;

        for (String number : numArr) {
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber<=1000){
                if (parsedNumber < 0) {
                    // Storing negative numbers
                    negativeNumbers.add(parsedNumber);
                }

                result += parsedNumber;
            }
        }
        // If there are negative numbers, display in console with the exception message
        if (!negativeNumbers.isEmpty()) {
            String message = "Parsed negative numbers: " + negativeNumbers;
            throw new NumberFormatException(message);
        }

        return result;
    }
}