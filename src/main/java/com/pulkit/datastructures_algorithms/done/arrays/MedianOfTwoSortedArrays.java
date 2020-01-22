package com.pulkit.datastructures_algorithms.done.arrays;


/*
n=9
1,5,10,15,20,25,30,33,34
m=9
3,6,9,16,18,19,26,31,32
m+n=18
1,3,5,6,9,10,15,16 ,18,19, 20,25,26,30,31,32,33,34

n=4
1,5,10,15
m=3
3,6,9
m+n =7
1,3,5 ,6, 9,10,15

n=2
1,5
m=2
3,6
m+n =4
1,3,5,6

n=2
1,2
m=2
3,4
m+n =4
1,2,3,4
*/


public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        //TODO: To be fixed, Output is coming 5
        //Expected output - 6
        // 1,3,5, 6 ,9,10,15
        //int array1[] = {1, 5, 10, 15};
        //int array2[] = {3, 6, 9};

        //TODO: To be fixed, Output is coming 18 for 18 only
        //Expected output - 18 should be for 18 and 19
        int array1[] = {1, 5, 10, 15, 20, 25, 30, 33, 34};
        int array2[] = {3, 6, 9, 16, 18, 19, 26, 31, 32};

        int median = findMedian(array1, 0, array1.length - 1,
                array2, 0, array2.length - 1);

        System.out.println(median);
    }

    private static int findMedian(int array1[], int low1, int end1,
                                  int array2[], int low2, int end2) {

        if (low1 == end1 && low2 == end2) {
            System.out.println(array1[low1] + " " + array2[low2]);
            return array1[low1] + array2[low2] / 2;
        }

        if (array1.length + array2.length % 2 != 0) {
            if (low1 == end1 && low2 + 1 == end2) {
                if (array1[low1] < array2[low2]) {
                    System.out.println(array2[low2]);
                    return array2[low2];
                }
                if (array2[low2] < array1[low1] && array1[low1] < array2[end2]) {
                    System.out.println(array1[low1]);
                    return array1[low1];
                } else {
                    System.out.println(array2[end2]);
                    return array2[end2];
                }
            }
            if (low2 == end2 && low1 + 1 == end1) {
                if (array2[low2] < array1[low1]) {
                    System.out.println(array1[low1]);
                    return array1[low1];
                }
                if (array1[low1] < array2[low2] && array2[low2] < array1[end1]) {
                    System.out.println(array2[low2]);
                    return array2[low2];
                } else {
                    System.out.println(array1[end1]);
                    return array1[end1];
                }
            }
        }

        if (array1.length + array2.length % 2 == 0) {
            if (low1 + 1 == end1 && low2 + 1 == end2) {
                if (array1[low1] < array2[low2] && array1[end1] > array2[end2]) {
                    System.out.println((array2[low2] + " " + array2[end2]));
                    return (array2[low2] + array2[end2]) / 2;
                } else if (array2[low2] < array1[low1] && array2[end2] > array1[end1]) {
                    System.out.println((array1[low1] + " " + array1[end1]));
                    return (array1[low1] + array1[end1]) / 2;
                } else if (array1[low1] < array2[low2]) {
                    System.out.println((array2[low2] + " " + array1[end1]));
                    return (array2[low2] + array1[end1]) / 2;
                } else {
                    System.out.println((array1[low1] + " " + array2[end2]));
                    return (array1[low1] + array2[end2]) / 2;
                }
            }
        }

        int mid1 = low1 + ((end1 - low1) / 2);
        int mid2 = low2 + ((end2 - low2) / 2);

        if (array1[mid1] >= array2[mid2]) {
            return findMedian(array1, low1, mid1, array2, mid2, end2);
        } else {
            return findMedian(array1, mid1, end1, array2, low2, mid2);
        }
    }
}