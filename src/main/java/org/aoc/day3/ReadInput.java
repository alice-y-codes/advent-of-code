package org.aoc.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadInput {

    public static List<String> readInput() throws IOException {
        List<String> multLines = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        String regex = "(mul\\(\\d{1,3},\\d{1,3}\\))|do\\(\\)|don't\\(\\)";
        Pattern pattern = Pattern.compile(regex);

        try {
            System.out.println("Enter a string (or type 'exit' to stop):");
            while (!(input = reader.readLine()).equalsIgnoreCase("exit")) {
                // Regex for matching "mul(x,y)" where x and y are numbers

                Matcher matcher = pattern.matcher(input);

                // Find and add all matches
                while (matcher.find()) {
                    multLines.add(matcher.group());
                }

                // Prompt user for next line
                System.out.println("Enter another string (or type 'exit' to stop):");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return multLines;
    }
}
