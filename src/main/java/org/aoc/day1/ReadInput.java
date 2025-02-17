package org.aoc.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ReadInput {
    public static Map<String, List<Integer>> readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) { // Read until empty line or EOF
            StringTokenizer st = new StringTokenizer(line);
            if (st.countTokens() == 2) { // Ensure two numbers per line. Important for your data.
                try {
                    int num1 = Integer.parseInt(st.nextToken());
                    int num2 = Integer.parseInt(st.nextToken());
                    list1.add(num1);
                    list2.add(num2);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input: " + line); // Handle parsing errors.
                }
            } else {
                System.err.println("Invalid input line (expected two numbers): " + line);
            }
        }

        br.close(); // Close the reader

        // Now you have your data in list1 and list2
        Map<String, List<Integer>> listsMap = new HashMap<>();
        listsMap.put("List 1", list1);
        listsMap.put("List 2", list2);

        return listsMap;
    }
}
