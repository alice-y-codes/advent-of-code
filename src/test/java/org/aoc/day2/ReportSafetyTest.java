package org.aoc.day2;
import org.junit.Test;

import static org.aoc.day2.part1.ReportSafety.hasCorrectGaps;
import static org.junit.Assert.*;
import java.util.Arrays;

public class ReportSafetyTest {

    @Test
    public void testSafeDescendingLevels() {
        // 7, 6, 4, 2, 1 - All gaps are either 1 or 2, so it's safe
        assertTrue(hasCorrectGaps(Arrays.asList(7, 6, 4, 2, 1)));
    }

    @Test
    public void testUnsafeIncreaseByFive() {
        // 1, 2, 7, 8, 9 - The gap between 2 and 7 is 5, which is unsafe
        assertFalse(hasCorrectGaps(Arrays.asList(1, 2, 7, 8, 9)));
    }

    @Test
    public void testUnsafeDecreaseByFour() {
        // 9, 7, 6, 2, 1 - The gap between 6 and 2 is 4, which is unsafe
        assertFalse(hasCorrectGaps(Arrays.asList(9, 7, 6, 2, 1)));
    }

    @Test
    public void testUnsafeEqualValues() {
        // 8, 6, 4, 4, 1 - The gap between 4 and 4 is zero, which is neither increase nor decrease
        assertFalse(hasCorrectGaps(Arrays.asList(8, 6, 4, 4, 1)));
    }

    @Test
    public void testSafeIncreasingLevels() {
        // 1, 3, 6, 7, 9 - All gaps are either 1, 2, or 3, so it's safe
        assertTrue(hasCorrectGaps(Arrays.asList(1, 3, 6, 7, 9)));
    }
}
