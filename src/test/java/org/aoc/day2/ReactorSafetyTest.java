package org.aoc.day2;

import org.aoc.day2.part2.ReactorSafety;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class ReactorSafetyTest {

    @Test
    public void testSafeWithoutRemovingAnyLevel() {
        List<List<Integer>> multiLevels = Arrays.asList(
                Arrays.asList(7, 6, 4, 2, 1)  // Safe without removing any level.
        );

        int result = ReactorSafety.countSafeReports(multiLevels);
        assertEquals(1, result);
    }

    @Test
    public void testUnsafeRegardlessOfWhichLevelIsRemoved() {
        List<List<Integer>> multiLevels = Arrays.asList(
                Arrays.asList(1, 2, 7, 8, 9)  // Unsafe regardless of which level is removed.
        );

        int result = ReactorSafety.countSafeReports(multiLevels);
        assertEquals(0, result);
    }

    @Test
    public void testAnotherUnsafeCase() {
        List<List<Integer>> multiLevels = Arrays.asList(
                Arrays.asList(9, 7, 6, 2, 1)  // Unsafe regardless of which level is removed.
        );

        int result = ReactorSafety.countSafeReports(multiLevels);
        assertEquals(0, result);
    }

    @Test
    public void testSafeByRemovingLevel() {
        List<List<Integer>> multiLevels = Arrays.asList(
                Arrays.asList(1, 3, 2, 4, 5)  // Safe by removing the second level (3).
        );

        int result = ReactorSafety.countSafeReports(multiLevels);
        assertEquals(1, result);
    }

    @Test
    public void testSafeByRemovingAnotherLevel() {
        List<List<Integer>> multiLevels = Arrays.asList(
                Arrays.asList(8, 6, 4, 4, 1)  // Safe by removing the third level (4).
        );

        int result = ReactorSafety.countSafeReports(multiLevels);
        assertEquals(1, result);
    }

    @Test
    public void testSafeWithoutRemovingAnyLevelAgain() {
        List<List<Integer>> multiLevels = Arrays.asList(
                Arrays.asList(1, 3, 6, 7, 9)  // Safe without removing any level.
        );

        int result = ReactorSafety.countSafeReports(multiLevels);
        assertEquals(1, result);
    }
}
