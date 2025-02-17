package org.aoc.day3;

import java.math.BigInteger;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComputerProgram {

    public static BigInteger calculateSum2(List<String> multLines) {
        BigInteger sum = BigInteger.ZERO;  // Initialize to BigInteger.ZERO

        for (String line : multLines) {
            int[] numbers = convertToDigits(line);  // Convert to array of integers
            BigInteger result = multiply(numbers);  // Multiply the numbers
            sum = sum.add(result);  // Use BigInteger's add method
        }

        return sum;
    }

    public static BigInteger calculateSum(List<String> multLines) {
        BigInteger sum = BigInteger.ZERO;
        boolean canMultiply = true;
        for (int i = 0; i < multLines.size(); i++) {
            if (multLines.get(i).equals("do()")) {
                canMultiply = true;
            }

            if (multLines.get(i).equals("don't()")) {
                canMultiply = false;
            }

            if(canMultiply) {
                int[] numbers = convertToDigits(multLines.get(i));
                BigInteger result = multiply(numbers);
                sum = sum.add(result);
            }
        }

        return sum;
    }

    private static int[] convertToDigits(String line) {

        String regex = "mul\\((\\d+),(\\d+)\\)";  // Regex to match mul(X,Y) format
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            // Convert the extracted numbers to integers and return as an array
            int firstNum = Integer.parseInt(matcher.group(1));
            int secondNum = Integer.parseInt(matcher.group(2));
            return new int[]{firstNum, secondNum};
        }

        return new int[]{0, 0};  // Default in case of no match
    }

    // Method to multiply two numbers and return a BigInteger
    private static BigInteger multiply(int[] numbers) {
        // Convert int values to BigInteger and multiply
        BigInteger firstNum = BigInteger.valueOf(numbers[0]);
        BigInteger secondNum = BigInteger.valueOf(numbers[1]);
        System.out.println(firstNum.multiply(secondNum));
        return firstNum.multiply(secondNum);  // Multiply BigIntegers
    }
}
