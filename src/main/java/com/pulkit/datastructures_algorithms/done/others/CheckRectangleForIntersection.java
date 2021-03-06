package com.pulkit.datastructures_algorithms.done.others;/*
    |
 7  .        .    .
    |
 6  . .  .
    |
 5  .
    |
 4  .
    |
 3  . .  .   .    .
    |
 2  .
    |
 1  .
    |
    ._._._._._._._._.
    0 1 2 3 4 5 6 7
*/

import static java.lang.System.out;

public class CheckRectangleForIntersection {
    public static void main(String[] args) {
        //Another Test case with user input
        /*
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();
        int E = scanner.nextInt();
        int F = scanner.nextInt();
        int G = scanner.nextInt();
        int H = scanner.nextInt();
        Rectangle firstRectangle = new Rectangle(new Coordinate(A, B), new Coordinate(C, D));
        Rectangle secondRectangle = new Rectangle(new Coordinate(E, F), new Coordinate(G, H));
        */

        //Another Test case
        //Expected No
        //Rectangle firstRectangle = new Rectangle(new Coordinate(1, 6), new Coordinate(2, 8));
        //Rectangle secondRectangle = new Rectangle(new Coordinate(3, 2), new Coordinate(5, 3));

        //Another Test case
        //Expected Yes
        //Rectangle firstRectangle = new Rectangle(new Coordinate(1, 3), new Coordinate(4, 5));
        //Rectangle secondRectangle = new Rectangle(new Coordinate(3, 2), new Coordinate(5, 4));

        //Another Test case
        //Expected Yes
        //Rectangle firstRectangle = new Rectangle(new Coordinate(1, 3), new Coordinate(3, 6));
        //Rectangle secondRectangle = new Rectangle(new Coordinate(1, 1), new Coordinate(3, 4));

        //Another Test case
        //Expected Yes
        //Rectangle firstRectangle = new Rectangle(new Coordinate(1, 1), new Coordinate(5, 5));
        //Rectangle secondRectangle = new Rectangle(new Coordinate(3, 3), new Coordinate(7, 7));

        //Another Test case
        //Expected No
        //Rectangle firstRectangle = new Rectangle(new Coordinate(1, 1), new Coordinate(3, 3));
        //Rectangle secondRectangle = new Rectangle(new Coordinate(5, 5), new Coordinate(7, 7));

        //Expected No
        Rectangle firstRectangle = new Rectangle(new Coordinate(47, 10), new Coordinate(57, 73));
        Rectangle secondRectangle = new Rectangle(new Coordinate(68, 3), new Coordinate(88, 63));

        //Assuming first rectangle is always below, If not then swap
        if (firstRectangle.lowerLeftMost.y > secondRectangle.lowerLeftMost.y) {
            out.println("Yes swapped");
            Rectangle temp = firstRectangle;
            firstRectangle = secondRectangle;
            secondRectangle = temp;
        }

        findIntersection(firstRectangle, secondRectangle);
    }


    private static void findIntersection(Rectangle firstRectangle, Rectangle secondRectangle) {
        if (isUpperRightXIsGreaterThanLowerLeftX(firstRectangle, secondRectangle)
                && isUpperRightYIsGreaterThanLowerLeftY(firstRectangle, secondRectangle)) {
            if (isLowerLeftXIsLessThanUpperRightX(firstRectangle, secondRectangle)
                    && isLowerLeftYIsLessThanUpperRightY(firstRectangle, secondRectangle)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        } else {
            out.println("No");
        }
    }

    private static boolean isUpperRightXIsGreaterThanLowerLeftX(Rectangle firstRectangle, Rectangle secondRectangle) {
        return firstRectangle.upperRightMost.x > secondRectangle.lowerLeftMost.x;
    }

    private static boolean isUpperRightYIsGreaterThanLowerLeftY(Rectangle firstRectangle, Rectangle secondRectangle) {
        return firstRectangle.upperRightMost.y > secondRectangle.lowerLeftMost.y;
    }

    private static boolean isLowerLeftXIsLessThanUpperRightX(Rectangle firstRectangle, Rectangle secondRectangle) {
        return firstRectangle.lowerLeftMost.x < secondRectangle.upperRightMost.x;
    }

    private static boolean isLowerLeftYIsLessThanUpperRightY(Rectangle firstRectangle, Rectangle secondRectangle) {
        return firstRectangle.lowerLeftMost.y < secondRectangle.upperRightMost.y;
    }
}

class Rectangle {
    Coordinate lowerLeftMost;
    Coordinate upperRightMost;

    Rectangle(Coordinate upperLeftMost, Coordinate lowerRightMost) {
        this.lowerLeftMost = upperLeftMost;
        this.upperRightMost = lowerRightMost;
    }
}

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}