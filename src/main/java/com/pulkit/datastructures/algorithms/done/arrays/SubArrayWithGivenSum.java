package com.pulkit.datastructures.algorithms.done.arrays;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        //Test Case 1
        //Expected Output - com.pulkit.DsAlgo.Pair{start=1, end=3}
        int input1[] = {1, 2, 3, 7, 5};
        int givenSum1 = 12;
        System.out.println(find(input1, givenSum1));

        //Test Case 2
        //Expected Output - com.pulkit.DsAlgo.Pair{start=0, end=4}
        int input2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int givenSum2 = 15;
        System.out.println(find(input2, givenSum2));
    }

    private static Pair find(int inputArray[], int sum) {
        int length = inputArray.length;

        if (length == 0)
            return new Pair(0, 0);

        int slow = 0, fast = 0;
        int currentSum = 0;

        Pair subArrayRange = new Pair();

        while (fast < length) {
            while (fast < length && currentSum <= sum) {
                findMaxSubArrayBetweenOldAndNew(sum, slow, fast, currentSum, subArrayRange);

                currentSum = currentSum + inputArray[fast];
                fast++;
            }

            while (slow < fast && currentSum >= sum) {
                findMaxSubArrayBetweenOldAndNew(sum, slow, fast, currentSum, subArrayRange);

                currentSum = currentSum - inputArray[slow];
                slow++;
            }
        }
        return subArrayRange;
    }

    private static void findMaxSubArrayBetweenOldAndNew(int sum, int slow, int fast, int currentSum, Pair subArrayRange) {
        if (currentSum == sum) {
            int oldSubArrayStart = subArrayRange.start;
            int oldSubArrayEnd = subArrayRange.end;

            int oldSubArrayLength = oldSubArrayEnd - oldSubArrayStart;
            int newSubArrayLength = fast - slow - 1;

            if (oldSubArrayLength < newSubArrayLength) {
                subArrayRange.end = fast - 1;
                subArrayRange.start = slow;
            }
        }
    }
}