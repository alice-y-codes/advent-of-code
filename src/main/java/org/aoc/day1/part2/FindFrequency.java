package org.aoc.day1.part2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequency {
    public static long findFrequency(Map<String, List<Integer>> listMap) {
        List<Integer> list1 = listMap.get("List 1");
        List<Integer> list2 = listMap.get("List 2");
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        Collections.sort(list1);
        Collections.sort(list2);

        for (int i = 0; i < list1.size(); i++) {
            Integer currentNumber = list1.get(i);
            int frequency = Collections.frequency(list2, currentNumber);
            frequencyMap.put(currentNumber, frequency);
        }

        return findSimilarityScore(frequencyMap);
    }

    private static long findSimilarityScore(Map<Integer, Integer> frequencyMap) {
        long sum = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Integer currentNumber = entry.getKey();
            Integer frequency = entry.getValue();
            sum += (long) currentNumber * frequency;
        }
        return sum;
    }
}
