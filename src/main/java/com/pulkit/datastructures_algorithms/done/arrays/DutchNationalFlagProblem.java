package com.pulkit.datastructures_algorithms.done.arrays;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        //Another Test case
        //int a[] = {2, 2, 2, 2, 1, 1, 1, 0, 0, 0};

        //Another Test case
        //int a[] = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2};

        //Another Test case
        //int a[] = {0, 1, 2, 0, 1, 2, 0, 1, 2};

        //Another Test case
        //Not Working when mid++ in case 2
        //int a[] = {2, 2, 2, 2, 0, 0, 0, 1, 1, 1};

        //Another Test case
        //int a[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        int a[] = {0, 1, 2, 0, 1, 2, 0, 1, 2, 2};

        //Dry run of pointers
        /*
                 l              m
        0, 0, 0, 1, 1, 2, 2, 1, 2, 2
                             h
         */

        createFlag(a);

        for (Integer i : a) {
            System.out.println(i);
        }
    }

    private static void createFlag(int[] a) {
        int low = 0;
        int mid = 0;
        int high = a.length - 1;

        while (mid <= high) {
            switch (a[mid]) {
                case 2:
                    swap(a, mid, high);
                    high--;
                    break;
                case 1:
                    mid++;
                    break;
                case 0:
                    swap(a, low, mid);
                    low++;
                    mid++;
                    break;
            }
        }
    }

    private static void swap(int[] a, int position1, int position2) {
        int temp = a[position1];
        a[position1] = a[position2];
        a[position2] = temp;
    }
}