package com.pulkit.DsAlgo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] stockPrices1 = {1, 2, 3, 4, 5, 6};
        int[] expectedOutput1 = {1, 2, 3, 4, 5, 6};
        testCase(stockPrices1, expectedOutput1);

        int[] stockPrices2 = {6, 5, 4, 3, 2, 1};
        int[] expectedOutput2 = {1, 1, 1, 1, 1, 1};
        testCase(stockPrices2, expectedOutput2);

        int[] stockPrices3 = {10, 4, 3, 5, 90, 120, 80};
        int[] expectedOutput3 = {1, 1, 1, 3, 5, 6, 1};
        testCase(stockPrices3, expectedOutput3);
    }

    private static void calculateAnotherApproach(int[] stockPrices, List<Integer> actualOutput) {
        Stack<Integer> stack = new Stack<>();

        stack.add(0);
        actualOutput.add(1);

        int index = 1;
        int length = stockPrices.length;

        while (index < length) {
            while (isBoundarySafe(index, length, stack)
                    && stockPrices[stack.peek()] > stockPrices[index]) {
                actualOutput.add(index - stack.peek());
                stack.push(index);
                index++;
            }

            while (isBoundarySafe(index, length, stack)
                    && stockPrices[stack.peek()] <= stockPrices[index]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                actualOutput.add(index + 1);
            } else {
                if (index < length)
                    actualOutput.add(index - stack.peek());
            }

            stack.push(index);
            index++;
        }
    }

    private static boolean isBoundarySafe(int index, int length, Stack<Integer> stack) {
        return (index < length) && !(stack.isEmpty());
    }

    private static void calculate(int[] stockPrices, List<Integer> actualOutput) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        actualOutput.add(1);

        int index = 1;
        int arrayLength = stockPrices.length;

        while (index < arrayLength) {
            while (index < arrayLength
                    && stockPrices[stack.peek()] > stockPrices[index]) {
                stack.push(index);
                index++;
            }

            while (index < arrayLength && stack.size() != 1
                    && stockPrices[stack.peek()] <= stockPrices[index]) {
                if (stack.size() > 1) {
                    stack.pop();
                }
            }
            int result = (index - stack.peek()) + 1;
            actualOutput.add(result);

            if (stack.size() == 1) {
                stack.pop();
                stack.push(index);
            }
            index++;
        }
    }

    private static void testCase(int[] stockPrices, int[] expectedOutput) {
        LinkedList<Integer> actualOutput = new LinkedList<>();
        calculateAnotherApproach(stockPrices, actualOutput);
        compareActualAndExpected(expectedOutput, actualOutput);
        consoleOutputCleaner();
    }

    private static void compareActualAndExpected(int[] expectedOutput, List<Integer> actualOutput) {
        int index = 0;
        boolean correctAnswer = true;

        if (expectedOutput.length != actualOutput.size()) {
            System.out.println("Test Failed");
            correctAnswer = false;
        } else {
            for (Integer element : actualOutput) {
                if (element != expectedOutput[index]) {
                    System.out.println("Test Failed");
                    correctAnswer = false;
                    break;
                }
                index++;
            }
        }

        if (correctAnswer) {
            System.out.println("Test Passed");
        }

        System.out.println("Actual Output");
        for (Integer element : actualOutput) {
            System.out.print(element + " ");
        }

        System.out.println();
        System.out.println("Expected Output");
        for (int iterator = 0; iterator < expectedOutput.length; iterator++) {
            System.out.print(expectedOutput[iterator] + " ");
        }
    }

    private static void consoleOutputCleaner() {
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("");
    }
}