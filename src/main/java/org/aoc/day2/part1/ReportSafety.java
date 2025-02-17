package org.aoc.day2.part1;

import java.util.List;

public class ReportSafety {
    public static int reportSafety(List<List<Integer>> multiLevels) {
        int safetyCount = 0;

        for (List<Integer> level : multiLevels) {
            if (isSorted(level) && hasCorrectGaps(level)) {
                safetyCount++;
            }
        }

        return safetyCount;
    }

    public static boolean isSorted(List<Integer> list) {
        boolean ascending = true;
        boolean descending = true;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i - 1)) {
                descending = false;
            } else if (list.get(i) < list.get(i - 1)) {
                ascending = false;
            }
        }

        return ascending || descending; // True if either condition holds
    }

    public static boolean hasCorrectGaps(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int gap = Math.abs(list.get(i) - list.get(i - 1));
            if (gap < 1 || gap > 3) {
                return false;
            }
        }
        return true;
    }
}
