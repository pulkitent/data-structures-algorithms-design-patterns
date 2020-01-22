package com.pulkit.datastructures_algorithms.done.arrays;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class MaximumInSlidingWindowOfGivenSize {
    public static void main(String[] args) {
        //Expected output - 3, 9, 10, 10 ,10
        int array[] = {3, 2, 1, 9, 10, 5, 4};
        int windowSize = 3;
        firstTestCase(array, windowSize);

        //Expected output - 3, 4, 5, 6, 7, 8, 9
        int array1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int windowSize1 = 3;
        secondTestCase(array1, windowSize1);

        //Expected output - 9, 8, 7, 6, 5, 4, 3
        //TODO:Fix This Test
        int array2[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int windowSize2 = 3;
        thirdTestCase(array2, windowSize2);

        //Expected output - 3, 10, 10, 10
        //TODO:Fix This Test
        int array3[] = {3, 2, 10, 9, 10, 5, 4};
        int windowSize3 = 3;
        fourthTestCase(array3, windowSize3);
    }

    private static void find(int[] array, int windowSize, List<Integer> outputList) {
        if (array.length == 0)
            return;

        Deque<Integer> queue = new LinkedList<>();
        queue.add(array[0]);

        for (int index = 1; index < windowSize; index++) {
            if (array[index] > queue.peek()) {
                queue.remove();
            }
            queue.add(array[index]);
        }

        outputList.add(queue.peek());
        //System.out.println("" + queue.peek());

        for (int index = windowSize; index < array.length; index++) {
            if (!queue.isEmpty() && array[index] > queue.peek()) {
                while (!queue.isEmpty() && queue.peek() < array[index]) {
                    queue.remove();
                }
            }
            queue.add(array[index]);
            outputList.add(queue.peek());
            //System.out.println("" + queue.peek());

            while (queue.size() > windowSize) {
                queue.remove();
            }
        }
    }

    private static void fourthTestCase(int[] array3, int windowSize3) {
        List<Integer> expectedOutputList4 = asList(3, 10, 10, 10);
        LinkedList<Integer> outputList4 = new LinkedList<>();

        find(array3, windowSize3, outputList4);
        expectedOutputList4.equals(outputList4);

        if (outputList4.equals(expectedOutputList4)) {
            System.out.println("Passing test 4");
            System.out.println(" ");
        } else {
            System.out.println("Failing test 4");
            System.out.println(" ");
        }
    }

    private static void thirdTestCase(int[] array2, int windowSize2) {
        List<Integer> expectedOutputList3 = asList(9, 8, 7, 6, 5, 4, 3);
        LinkedList<Integer> outputList3 = new LinkedList<>();

        find(array2, windowSize2, outputList3);
        expectedOutputList3.equals(outputList3);

        if (outputList3.equals(expectedOutputList3)) {
            System.out.println("Passing test 3");
            System.out.println(" ");
        } else {
            System.out.println("Failing test 3");
            System.out.println(" ");
        }
    }

    private static void secondTestCase(int[] array1, int windowSize1) {
        List<Integer> expectedOutputList2 = asList(3, 4, 5, 6, 7, 8, 9);
        LinkedList<Integer> outputList2 = new LinkedList<>();

        find(array1, windowSize1, outputList2);
        outputList2.equals(expectedOutputList2);

        if (outputList2.equals(expectedOutputList2)) {
            System.out.println("Passing test 2");
            System.out.println(" ");
        } else {
            System.out.println("Failing test 2");
            System.out.println(" ");
        }
    }

    private static void firstTestCase(int[] array, int windowSize) {
        List<Integer> expectedOutputList = asList(3, 9, 10, 10, 10);
        List<Integer> outputList = new ArrayList<>();

        find(array, windowSize, outputList);

        if (outputList.equals(expectedOutputList)) {
            System.out.println("Passing test 1");
            System.out.println(" ");
        } else {
            System.out.println("Failing test 1");
            System.out.println(" ");
        }
    }
}