package org.aoc.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadInput {
    public static List<List<String>> readInput() throws IOException {

        List<List<String>> xmasGrid = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/aoc/day4/xmasGrid.txt"))) {
            String line;
            while ((line = br.readLine()) != null && !line.isBlank()) {
                try {
                    List<String> xmasLine = Arrays.asList(line.split(""));
                    xmasGrid.add(xmasLine);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return xmasGrid;
    }
}
