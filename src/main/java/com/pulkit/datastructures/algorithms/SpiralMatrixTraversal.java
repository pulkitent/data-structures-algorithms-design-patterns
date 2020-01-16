package com.pulkit.DsAlgo;

public class SpiralMatrixTraversal {
    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };

        traversal(matrix, 6);
    }

    public static void traversal(int matrix[][], int size) {
        int totalNumberOfElements = size * size;

        int rowIndex = 0;
        int columnIndex = size - 1;

        int horizontalRightIndexStarter = 0;
        int horizontalRightIndexStopper = size;

        int verticalDownIndexStarter = 1;
        int verticalDownIndexStopper = size;

        int horizontalLeftIndexStarter = size - 2;
        int horizontalLeftIndexStopper = 0;

        int verticalUpIndexStarter = size - 2;
        int verticalUpIndexStopper = 1;

        int counter = 0;

        while (counter < totalNumberOfElements) {
            if (horizontalRightIndexStarter < size) {
                for (int horizontalRightIndex = horizontalRightIndexStarter;
                     horizontalRightIndex < horizontalRightIndexStopper; horizontalRightIndex++) {
                    System.out.print(matrix[rowIndex][horizontalRightIndex] + " ");
                    counter++;
                }
            }

            if (verticalDownIndexStarter < size) {
                for (int verticalDownIndex = verticalDownIndexStarter;
                     verticalDownIndex < verticalDownIndexStopper; verticalDownIndex++) {
                    System.out.print(matrix[verticalDownIndex][columnIndex] + " ");
                    counter++;
                }
            }

            if (horizontalLeftIndexStarter > -1) {
                for (int horizontalLeftIndex = horizontalLeftIndexStarter;
                     horizontalLeftIndex >= horizontalLeftIndexStopper; horizontalLeftIndex--) {
                    System.out.print(matrix[columnIndex][horizontalLeftIndex] + " ");
                    counter++;
                }
            }

            if (verticalUpIndexStarter > -1) {
                for (int verticalUpIndex = verticalUpIndexStarter;
                     verticalUpIndex >= verticalUpIndexStopper; verticalUpIndex--) {
                    System.out.print(matrix[verticalUpIndex][rowIndex] + " ");
                    counter++;
                }
            }

            System.out.println(" ");

            rowIndex++;
            columnIndex--;

            horizontalRightIndexStarter++;
            horizontalRightIndexStopper--;

            verticalDownIndexStarter++;
            verticalDownIndexStopper--;

            horizontalLeftIndexStarter--;
            horizontalLeftIndexStopper++;

            verticalUpIndexStarter--;
            verticalUpIndexStopper++;
        }
    }
}