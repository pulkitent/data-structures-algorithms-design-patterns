package com.pulkit.datastructures_algorithms.done.arrays;

//TODO: Need to relook at algorithm
public class BuyAndSellStockOnlyTwice {
    public static void main(String[] args) {
        //Expected 7 (buy at 5 index and sell at 8 index)
        int a[] = {12, 11, 13, 9, 12, 8, 14, 13, 15}; //12 -1 2 -4 3 -4 6 -1 2 // a,b-a,c-b,d-c,e-d

        //Expected 9 (buy at 0 index and sell at 1 index)
        //int a[] = {2, 11, 1, 4, 7};

        //Expected 0
        //int a[] = {21, 11, 9, 8, 7};

        calculateAdjacentDifferences(a);
    }

    private static void calculateAdjacentDifferences(int[] a) {
        for (int index = a.length - 1; index > 0; index--) {
            a[index] = a[index] - a[index - 1];
        }
    }

    private static int findMaxSumSubarray(int[] a) {
        int maximumSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int index = 1; index < a.length; index++) {
            currentSum = currentSum + a[index];

            if (currentSum < 0) {
                currentSum = 0;
            }
            maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }
}