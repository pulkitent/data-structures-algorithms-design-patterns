//package com.mckinsey.engage.risk;
//
//public class PerfectSquares {
//    int counter = 0;
//
//    public int numSquares(int n) {
//        counter = n;
//        int[] squares = new int[(int) Math.pow(n, 0.5)];
//        int square = squares.length;
//
//        for (int index = 0; index < squares.length; index++) {
//            squares[index] = square * square;
//            square--;
//        }
//
//        getCountOfPerfectSquares(n, squares, 0);
//        return counter;
//    }
//
//    int getCountOfPerfectSquares(int number, int[] squares, int index) {
//        if (number < 0)
//            return number;
//
//        if (number == 0)
//            return;
//
//        for (int anotherIndex = index; anotherIndex < squares.length; anotherIndex++) {
//            counter++;
//            getCountOfPerfectSquares(number - squares[anotherIndex], squares, index);
//            counter--;
//        }
//    }
//}
