package org.aoc.day4;

import java.io.IOException;
import java.util.List;

import static org.aoc.day4.ReadInput.readInput;
import static org.aoc.day4.WordSearch.countWordOccurrences;

public class Main {
    public static void main(String[] args) throws IOException {
        List<List<String>> xmasGrid = readInput();
        char[][] grid = xmasGrid.stream()
                .map(letter -> {
                    // Convert each List<Character> to a char[]
                    char[] row = new char[letter.size()];
                    for (int i = 0; i < letter.size(); i++) {
                        row[i] = letter.get(i).charAt(0);
                    }
                    return row;
                })
                .toArray(char[][]::new);

        String word = "MAS";
        int result = countWordOccurrences(grid, word);
        System.out.println("Total occurrences of '" + word + "': " + result);
    }
}
