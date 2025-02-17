package org.aoc.day1.part1;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CalculateDistance {
    public static long calculateDistance(Map<String, List<Integer>> listMap) {
        long sum = 0;

        // sort both list
        Collections.sort(listMap.get("List 1"));
        Collections.sort(listMap.get("List 2"));
        // loop over both lists, find the difference with math.abs
        for (int i = 0; i < listMap.get("List 1").size(); i++) {
             Integer difference = listMap.get("List 1").get(i) - listMap.get("List 2").get(i);
             System.out.println(difference);
             sum += Math.abs(difference);

        }
        // add it to the sum

        return sum;
    }
}
