package org.aoc.day4;

public class WordSearch {
    static int[][] directions = {
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Diagonals ↘, ↙, ↗, ↖
    };

    public static int countWordOccurrences(char[][] grid, String word) {
        int rows = grid.length, cols = grid[0].length;
        int wordLength = word.length();
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                for (int[] dir : directions) {
                    if (search(grid, word, r, c, dir[0], dir[1], wordLength)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean search(char[][] grid, String word, int r, int c, int dr, int dc, int wordLength) {
        int rows = grid.length, cols = grid[0].length;

        for (int i = 0; i < wordLength; i++) {
            int nr = r + i * dr;
            int nc = c + i * dc;

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
