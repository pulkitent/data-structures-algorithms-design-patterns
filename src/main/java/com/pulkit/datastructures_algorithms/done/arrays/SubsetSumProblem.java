package com.pulkit.datastructures_algorithms.done.arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SubsetSumProblem {
    List<List<Integer>> finalList = new LinkedList<>();

    public static void main(String[] args) {
        int number = 10;
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stack<Integer> stack = new Stack<>();

        SubsetSumProblem subsetSumProblem = new SubsetSumProblem();
        subsetSumProblem.findSubsetsWithGivenSum(number, 0, array, stack);

        subsetSumProblem.finalList.forEach(list -> {
            for (Integer element : list) {
                System.out.print(element + " ");
            }
            System.out.println(" ");
        });
    }

    void findSubsetsWithGivenSum(int sum, int index, int array[], Stack<Integer> stack) {
        if (sum < 0) {
            return;
        }

        if (sum == 0) {
            this.finalList.add(new LinkedList<>(stack));
            return;
        }

        for (int i = index; i < array.length; i++) {
            stack.push(array[i]);
            findSubsetsWithGivenSum(sum - array[i], i, array, stack);
            stack.pop();
        }
    }
}