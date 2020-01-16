package com.pulkit.DsAlgo;

public class SearchRotatedArray {
    public static void main(String[] args) {
        //Expected Output on console - 6
        int[] array1 = {6, 7, 1, 2, 3, 4, 5};
        int element1 = 5;
        firstTestCase(array1, element1);

        //Expected Output on console - 2
        int[] array2 = {4, 5, 6, 1, 2, 3};
        int element2 = 6;
        secondTestCase(array2, element2);
    }

    private static int findElement(int[] array, int start, int end, int element) {
        int mid = (start + end) / 2;

        if (array[mid] == element) {
            return mid;
        }

        if (array[mid] > element) {
            return findElement(array, 0, mid, element);
        } else {
            return findElement(array, mid, end, element);
        }
    }

    private static int findPivot(int array[], int start, int end) {
        int mid = (start + end) / 2;

        if (array[mid - 1] > array[mid]) {
            return mid;
        }

        if (array[mid] < array[start]) {
            return findPivot(array, 0, mid);
        } else {
            return findPivot(array, mid, end);
        }
    }

    private static void secondTestCase(int[] array2, int element2) {
        int length2 = array2.length;
        int pivot2 = findPivot(array2, 0, array2.length);
        if (array2[0] > element2) {
            System.out.println(findElement(array2, pivot2, length2, element2));
        } else {
            System.out.println(findElement(array2, 0, pivot2, element2));
        }
    }

    private static void firstTestCase(int[] array1, int element1) {
        int length1 = array1.length;
        int pivot1 = findPivot(array1, 0, length1);
        if (array1[0] > element1) {
            System.out.println(findElement(array1, pivot1, length1, element1));
        } else {
            System.out.println(findElement(array1, 0, pivot1, element1));
        }
    }
}