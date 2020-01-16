package com.pulkit.DsAlgo;

import static java.lang.System.*;

public class MedianArrays {
    public static void main(String[] args) {
        int a[] = {3, 6, 9, 12, 18, 21}; // 1 15 20 3 15 99
        int b[] = {1, 5, 15, 20, 25, 30}; // 1 3 5 6 9 12 15 18 20 21 25 30

        //Another Test case
        //int b[] = {3, 6, 9, 12, 18, 21};// 3 3 6 6 9 9 12 12 18 18 21 21

        out.println(findMedian(a, b, 0, a.length, 0, b.length));
    }

    private static int findMedian(int[] firstArray, int[] secondArray,
                                  int firstArraySmallIndex, int firstArrayHighIndex,
                                  int secondArraySmallIndex, int secondArrayHighIndex) {

        if (ifBothArraysHaveSizeAsOne(firstArraySmallIndex, firstArrayHighIndex, secondArraySmallIndex,
                secondArrayHighIndex))
            return (firstArray[firstArraySmallIndex] + secondArray[secondArraySmallIndex]) / 2;

        if (ifBothArraysHaveSizeAsTwo(firstArraySmallIndex, firstArrayHighIndex, secondArraySmallIndex,
                secondArrayHighIndex))
            return (Math.max(firstArray[firstArraySmallIndex], secondArray[secondArraySmallIndex])
                    + Math.min(firstArray[firstArrayHighIndex], secondArray[secondArrayHighIndex])) / 2;

        int firstArrayMid = (firstArraySmallIndex + firstArrayHighIndex) / 2;
        int secondArrayMid = (secondArraySmallIndex + secondArrayHighIndex) / 2;

        int firstArrayMedian = getMedianForSingleArray(firstArray, firstArraySmallIndex, firstArrayHighIndex);
        int secondArrayMedian = getMedianForSingleArray(secondArray, secondArraySmallIndex, secondArrayHighIndex);

        if (firstArrayMedian == secondArrayMedian) {
            return firstArrayMedian;
        }

        if (firstArrayMedian < secondArrayMedian) {
            return findMedian(firstArray, secondArray, firstArrayMid, firstArrayHighIndex, secondArraySmallIndex,
                    secondArrayMid);
        } else {
            return findMedian(firstArray, secondArray, firstArraySmallIndex, firstArrayMid, secondArrayMid,
                    secondArrayHighIndex);
        }
    }

    private static boolean ifBothArraysHaveSizeAsTwo(int firstArraySmallIndex, int firstArrayHighIndex,
                                                     int secondArraySmallIndex, int secondArrayHighIndex) {
        return firstArraySmallIndex + 1 == firstArrayHighIndex && secondArraySmallIndex + 1 == secondArrayHighIndex;
    }

    private static boolean ifBothArraysHaveSizeAsOne(int firstArraySmallIndex, int firstArrayHighIndex,
                                                     int secondArraySmallIndex, int secondArrayHighIndex) {
        return firstArraySmallIndex == firstArrayHighIndex && secondArraySmallIndex == secondArrayHighIndex;
    }

    private static int getMedianForSingleArray(int array[], int low, int high) {
        int size = high - low;
        int mid = (low + high) / 2;

        if (size % 2 == 0) {
            return (array[mid - 1] + array[mid]) / 2;
        }
        return array[mid];
    }
}