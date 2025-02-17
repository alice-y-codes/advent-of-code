package org.aoc.day5;

import java.io.IOException;
import java.util.List;

import static org.aoc.day5.PageOrderManual.calculateSumOfMiddlePageNumber;
import static org.aoc.day5.ReadInput.readPages;
import static org.aoc.day5.ReadInput.readRules;

public class Main {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> orderRules = readRules();
        List<List<Integer>> pages = readPages();
        int sum = calculateSumOfMiddlePageNumber(pages, orderRules).get("middleSum");
        int unorderedSum = calculateSumOfMiddlePageNumber(pages, orderRules).get("unorderedSum");
        System.out.println(sum);
        System.out.println(unorderedSum);
    }
}
