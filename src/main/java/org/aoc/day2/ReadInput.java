package org.aoc.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadInput {
    public static List<List<Integer>> readInput() throws IOException {
        List<List<Integer>> multiLevels = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null && !line.isBlank()) { // Ensures non-empty input
                try {
                    List<Integer> level = parseLineToIntegerList(line);
                    multiLevels.add(level);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input: " + line);
                }
            }
        }
        return multiLevels;
    }

    private static List<Integer> parseLineToIntegerList(String line) {
        return Arrays.stream(line.trim().split("\\s+")) // Handles multiple spaces
                .map(Integer::parseInt) // Use parseInt (avoids unnecessary boxing)
                .collect(Collectors.toList()); // Collect as a list
    }
}
