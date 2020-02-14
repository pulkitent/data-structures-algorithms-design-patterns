package com.pulkit.datastructures_algorithms.done.graphs;//Matrix Example
/*
    00 01 02

    10 11 12

    20 21 22
*/

public class FindMaxProductPathMovingRightAndDown {
    public static void main(String[] args) {
        int inputMatrix[][] = {{1, 2, 99}, {4, 5, 6}, {7, 8, 9}};

        //Another Test case
        //int inputMatrix[][] = {{-1, 2, 3}, {4, 5, -6}, {7, 8, 9}};

        int maxProductSoFarMatrix[][] = {{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE},
                                        {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE},
                                        {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}};

        calculateMaxProductSoFarMatrix(inputMatrix, maxProductSoFarMatrix);

        System.out.println("Input Matrix");
        printMatrix(inputMatrix);

        System.out.println("Dp Matrix");
        printMatrix(maxProductSoFarMatrix);

        System.out.println("Print path");
        printPath(maxProductSoFarMatrix, inputMatrix);
    }

    private static void calculateMaxProductSoFarMatrix(int inputMatrix[][], int dpMatrix[][]) {
        dpMatrix[0][0] = inputMatrix[0][0];
        int rowSize = inputMatrix.length;

        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            int columnSize = inputMatrix[rowIndex].length;
            for (int columnIndex = 0; columnIndex < columnSize; columnIndex++) {
                int leftNeighbourColumnIndex = columnIndex + 1;

                if (leftNeighbourColumnIndex < columnSize &&
                        dpMatrix[rowIndex][columnIndex] * inputMatrix[rowIndex][leftNeighbourColumnIndex] >= inputMatrix[rowIndex][leftNeighbourColumnIndex]) {
                    dpMatrix[rowIndex][leftNeighbourColumnIndex] = dpMatrix[rowIndex][columnIndex] * inputMatrix[rowIndex][leftNeighbourColumnIndex];
                }

                int downNeighbourRowIndex = rowIndex + 1;

                if (downNeighbourRowIndex < rowSize &&
                        dpMatrix[rowIndex][columnIndex] * inputMatrix[downNeighbourRowIndex][columnIndex] >= inputMatrix[downNeighbourRowIndex][columnIndex]) {
                    dpMatrix[downNeighbourRowIndex][columnIndex] = dpMatrix[rowIndex][columnIndex] * inputMatrix[downNeighbourRowIndex][columnIndex];
                }
            }
        }
    }

    private static void printPath(int[][] maxProductSoFarMatrix, int[][] inputMatrix) {
        int rowSize = maxProductSoFarMatrix.length;
        int columnSize = maxProductSoFarMatrix.length;

        int rowIndex = rowSize - 1;
        int columnIndex = columnSize - 1;

        System.out.print(inputMatrix[rowIndex][columnIndex] + "<-");

        while (rowIndex != 0 || columnIndex != 0) {
            int temp = maxProductSoFarMatrix[rowIndex][columnIndex] / inputMatrix[rowIndex][columnIndex];

            if (columnIndex - 1 >= 0 && temp == maxProductSoFarMatrix[rowIndex][columnIndex - 1]) {
                columnIndex--;
                System.out.print(inputMatrix[rowIndex][columnIndex] + "<-");
            } else if (rowIndex - 1 >= 0 && temp == maxProductSoFarMatrix[rowIndex - 1][columnIndex]) {
                rowIndex--;
                System.out.print(inputMatrix[rowIndex][columnIndex] + "<-");
            }
        }
    }

    private static void printMatrix(int[][] maxProductSoFarMatrix) {
        for (int rowIndex = 0; rowIndex < maxProductSoFarMatrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < maxProductSoFarMatrix[rowIndex].length; columnIndex++) {
                System.out.print(maxProductSoFarMatrix[rowIndex][columnIndex] + " ");
            }
            System.out.println();
        }
    }
}