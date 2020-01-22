package com.pulkit.datastructures_algorithms.todo;

public class KnapSnackProblem {
    public static void main(String[] args) {

    }

    private static int findSolution(int currentWeight,
                                    int maxWeightAllowed, int index,
                                    int profits[], int weights[]) {
        if (index > profits.length)
            return 0;

        if (currentWeight > maxWeightAllowed) {
            return 0;
        }

        for (int i = index; i < profits.length; i++) {
            if (currentWeight + weights[i] <= maxWeightAllowed) {
                return profits[i] + findSolution(currentWeight + weights[i],
                        maxWeightAllowed, i + 1, profits, weights);

            }
        }

        //TODO: To be removed, Just added for project compilation
        return 0;
    }
}