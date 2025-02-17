package org.aoc.day3;


import java.io.IOException;
import java.util.List;

import static org.aoc.day3.ComputerProgram.calculateSum;
import static org.aoc.day3.ReadInput.readInput;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> multLines = readInput();
        System.out.println("The sum of the multiplication is: " + calculateSum(multLines));
    }
}
