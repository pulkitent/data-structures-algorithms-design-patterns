package com.pulkit.datastructures.algorithms.done.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        //Another Test case
        //List<Integer> list = Arrays.asList(1967513926, 1540383426, -1303455736, -521595368);

        //Another Test case
        //List<Integer> list = Arrays.asList(-1, -1);

        List<Integer> list = Arrays.asList(756898537, -1973594324, -2038664370, -184803526, 1424268980);

        System.out.println(find(list));
    }

    static ArrayList<Integer> find(List<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> finalList = new ArrayList<>();

        long currentSum = 0;
        long maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < A.size(); i++) {
            Integer element = A.get(i);
            if (element >= 0) {
                list.add(i);
                currentSum = currentSum + element;
            } else {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    currentSum = 0;
                    finalList = list;
                    list = new ArrayList<>();
                } else if (currentSum == maxSum) {
                    if (list.size() > finalList.size()) {
                        finalList = list;
                    } else if (list.size() == finalList.size()) {
                        if (!(list.isEmpty() && finalList.isEmpty())) {
                            if (list.get(0) > finalList.get(0)) {
                                finalList = list;
                            }
                        }
                    }
                }
            }
        }

        ArrayList<Integer> lastList = new ArrayList<>();

        for (Integer element : finalList) {
            lastList.add(A.get(element));
        }

        return lastList;
    }
}