package com.pulkit.datastructures_algorithms.done.arrays;

import java.util.HashSet;

public class LongestSequenceConsecutiveNumbers {
    public static void main(String[] args) {
        //Another Test case
        //int a[] = {5, 6, 7, 1, 5, 8, 3, 13, 12, 11, 10, 9};

        int a[] = {4, 2, 1, 6, 5};
        HashSet<Integer> hs = new HashSet<>();

        for (int index = 0; index < a.length; index++) {
            hs.add(a[index]);
        }

        int maxCount = Integer.MIN_VALUE;

        for (int index = 0; index < a.length; index++) {
            int nextConsecutiveNumber = a[index] + 1;
            int count = 1;

            while (hs.contains(nextConsecutiveNumber)) {
                count++;
                nextConsecutiveNumber++;
            }

            maxCount = Math.max(count, maxCount);
        }

        System.out.println(maxCount);
    }
}