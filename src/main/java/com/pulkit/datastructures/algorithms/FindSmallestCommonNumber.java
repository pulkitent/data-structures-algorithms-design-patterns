package com.pulkit.DsAlgo;

public class FindSmallestCommonNumber {
    public static void main(String[] args) {
        //Expected Output - 6
        int[] array1 = new int[]{1, 6, 10, 14, 50};
        int[] array2 = new int[]{-1, 6, 7, 8, 50};
        int[] array3 = new int[]{0, 6, 7, 10, 25, 30, 40};

        System.out.println(find(array1, array2, array3));
    }

    private static int find(int array1[], int array2[], int array3[]) {
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        int length1 = array1.length;
        int length2 = array2.length;
        int length3 = array3.length;

        while (index1 < length1 && index2 < length2 && index3 < length3) {
            if (array1[index1] == array2[index2] && array2[index2] == array3[index3]) {
                return array1[index1];
            }

            if (array1[index1] < array2[index2] && array1[index1] < array3[index3]) {
                index1++;
            }

            if (array2[index2] < array1[index1] && array2[index2] < array3[index3]) {
                index2++;
            }

            if (array3[index3] < array2[index2] && array3[index3] < array1[index1]) {
                index3++;
            }
        }
        return Integer.MIN_VALUE;
    }
}