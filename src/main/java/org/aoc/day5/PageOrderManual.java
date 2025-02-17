package org.aoc.day5;

import java.util.*;
import java.util.stream.Collectors;

public class PageOrderManual {
    public static Map<String, Integer> calculateSumOfMiddlePageNumber(List<List<Integer>> pages, List<List<Integer>> orderRules) {
        int middleSum = 0;
        int unorderedSum = 0;

        Map<String, Integer> sumsMap = new HashMap<>();


        List<int[]> constraints = orderRules.stream().map(x -> new int[]{x.get(0), x.get(1)}).collect(Collectors.toList());

        for (List<Integer> page : pages) {
            List<Integer> sortedPage = sortPage(page, constraints);
            if (checkOrder(page, sortedPage)) {
                middleSum += getMiddleNumber(page);
            } else {
                unorderedSum += getMiddleNumber(sortedPage);
            }

        }

        sumsMap.put("middleSum", middleSum);
        sumsMap.put("unorderedSum", unorderedSum);
        return sumsMap;
    }

    public static List<Integer> sortPage(List<Integer> page, List<int[]> constraints) {

        List<Integer> numbers = new ArrayList<>(page);
        Map<Integer, Set<Integer>> constrainttMap = new HashMap<>();

        for (int[] constraint : constraints) {
            int before = constraint[0], after = constraint[1];
            constrainttMap.computeIfAbsent(before, k -> new HashSet<>()).add(after);

        }

        numbers.sort((a, b) -> {
            if (constrainttMap.containsKey(a) && constrainttMap.get(a).contains(b)) {
                return -1;
            }

            if (constrainttMap.containsKey(b) && constrainttMap.get(b).contains(a)) {
                return 1;
            }

            return 0;
        });

        return numbers;
    }

    public static boolean checkOrder(List<Integer> page, List<Integer> orderedPage) {
        for (int i = 0; i < page.size(); i++) {
            if (page.get(i) != orderedPage.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static int getMiddleNumber(List<Integer> page) {
        return page.get(page.size() / 2);
    }
}
