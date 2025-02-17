package org.aoc.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadInput {
    public static List<List<Integer>> readRules() throws IOException {
        List<List<Integer>> orderRules = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/aoc/day5/page-order-rules.txt"))) {
            String line;
            while ((line = br.readLine()) != null && !line.isBlank()) {
                try {
                    List<Integer> rule = Arrays.stream(line.split("\\|")).map(Integer::parseInt).toList();
                    orderRules.add(rule);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return orderRules;
    }

    public static List<List<Integer>> readPages() throws IOException {
        List<List<Integer>> pages = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/aoc/day5/pages.txt"))) {
            String line;
            while ((line = br.readLine()) != null && !line.isBlank()) {
                try {
                    List<Integer> pageLine = Arrays.stream(line.split("\\,")).map(Integer::parseInt).toList();
                    pages.add(pageLine);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return pages;
    }
}
