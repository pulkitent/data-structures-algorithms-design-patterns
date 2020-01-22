package com.pulkit.datastructures_algorithms.done.arrays;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.*;

public class LargestNumber implements Comparator<Integer> {
    public static void main(String[] args) {
        Integer[] array = {3, 30, 34, 5, 9};
        out.println(formLargestNumberFrom(array));
    }

    private static String formLargestNumberFrom(Integer array[]) {
        LargestNumber largestNumber = new LargestNumber();
        Arrays.sort(array, largestNumber);

        StringBuilder result = new StringBuilder();

        for (Integer element : array) {
            result.append(element.toString());
        }

        return result.toString();
    }

    @Override
    public int compare(Integer firstElement, Integer secondElement) {
        String firstSecondElement = firstElement.toString() + secondElement.toString();
        String secondFirstElement = secondElement.toString() + firstElement.toString();

        return secondFirstElement.compareTo(firstSecondElement);
    }
}