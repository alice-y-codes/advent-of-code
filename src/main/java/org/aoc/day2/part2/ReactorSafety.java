package org.aoc.day2.part2;

import java.util.ArrayList;
import java.util.List;

public class ReactorSafety {

    // Check if the report is safe (monotonic and differences between adjacent levels are between 1 and 3)
    public static boolean isSafe(List<Integer> report) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < report.size(); i++) {
            int diff = Math.abs(report.get(i) - report.get(i - 1));
            if (diff < 1 || diff > 3) {
                return false;  // If the difference is not between 1 and 3
            }
            if (report.get(i) > report.get(i - 1)) {
                isDecreasing = false; // If there's an increase, it's not strictly decreasing
            } else if (report.get(i) < report.get(i - 1)) {
                isIncreasing = false; // If there's a decrease, it's not strictly increasing
            }
        }
        return isIncreasing || isDecreasing;
    }

    // Check if we can make the report safe by removing one element
    public static boolean isSafeWithRemoval(List<Integer> report) {
        for (int i = 0; i < report.size(); i++) {
            List<Integer> newReport = new ArrayList<>(report);
            newReport.remove(i);  // Remove the element at index i
            if (isSafe(newReport)) {
                return true;  // If removing this element makes the report safe
            }
        }
        return false;  // No valid removal was found to make the report safe
    }

    // Count the number of safe reports, considering the Problem Dampener
    public static int countSafeReports(List<List<Integer>> reports) {
        int safeCount = 0;
        for (List<Integer> report : reports) {
            if (isSafe(report) || isSafeWithRemoval(report)) {
                safeCount++;
            }
        }
        return safeCount;
    }
}
