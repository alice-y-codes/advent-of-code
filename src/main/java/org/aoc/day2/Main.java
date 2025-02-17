package org.aoc.day2;

import java.io.IOException;
import java.util.List;

import static org.aoc.day2.ReadInput.readInput;
import static org.aoc.day2.part2.ReactorSafety.countSafeReports;

public class Main {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> multiLevels = readInput();
        int result = countSafeReports(multiLevels);
        System.out.println("Number of safe reports: " + result);
    }
}
