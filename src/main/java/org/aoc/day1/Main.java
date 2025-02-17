package org.aoc.day1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.aoc.day1.part1.CalculateDistance.calculateDistance;
import static org.aoc.day1.ReadInput.readInput;
import static org.aoc.day1.part2.FindFrequency.findFrequency;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, List<Integer>> listMap = readInput();
        long distance = calculateDistance(listMap);
        System.out.println(distance);
        long similarityScore = findFrequency(listMap);
        System.out.println(similarityScore);
    }
}