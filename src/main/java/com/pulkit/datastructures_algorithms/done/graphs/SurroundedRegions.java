import java.util.HashSet;
import java.util.Set;


/*
input
[   ['O','O','O','O','X','X'],
    ['O','O','O','O','O','O'],
    ['O','X','O','X','O','O'],
    ['O','X','O','O','X','O'],
    ['O','X','O','X','O','O'],
    ['O','X','O','O','O','O']
]


mine output
[   ['O','O','O','O','X','X'],
    ['O','O','O','O','O','O'],
    ['O','X','X','X','X','O'],
    ['O','X','X','X','X','O'],
    ['O','X','X','X','X','O'],
    ['O','X','O','O','O','O']
]

expected
[   ['O','O','O','O','X','X'],
    ['O','O','O','O','O','O'],
    ['O','X','O','X','O','O'],
    ['O','X','O','O','X','O'],
    ['O','X','O','X','O','O'],
    ['O','X','O','O','O','O']
]
 */


class Solution {
    public static void main(String[] s) {
        char board[][] = {{'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == (board.length - 1) || j == 0 || j == (board[0].length - 1)) {
                    if (board[i][j] == 'O') {
                        makeBoundaryZerosToOne(board, i, j, new HashSet<>(), new HashSet<>());
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private static void makeBoundaryZerosToOne(char[][] board, int i, int j,
                                               Set<Integer> visitedI, Set<Integer> visitedJ) {
        if (i == 2 && j == 2) {
            System.out.println("debug");
        }

        if (isNotInRange(board, i, j))
            return;

        if (visitedI.contains((i+1) * 100000) && visitedJ.contains(j))
            return;

        board[i][j] = '1';
        visitedI.add((i+1) * 100000);
        visitedJ.add(j);

        if (!isNotInRange(board, i + 1, j) && board[i + 1][j] == 'O') {
            makeBoundaryZerosToOne(board, i + 1, j, visitedI, visitedJ);
        }
        if (!isNotInRange(board, i, j + 1) && board[i][j + 1] == 'O') {
            makeBoundaryZerosToOne(board, i, j + 1, visitedI, visitedJ);
        }
        if (!isNotInRange(board, i, j - 1) && board[i][j - 1] == 'O') {
            makeBoundaryZerosToOne(board, i, j - 1, visitedI, visitedJ);
        }
        if (!isNotInRange(board, i - 1, j) && board[i - 1][j] == 'O') {
            makeBoundaryZerosToOne(board, i - 1, j, visitedI, visitedJ);
        }
    }

    private static boolean isNotInRange(char[][] board, int i, int j) {
        return i < 0 || j < 0 || i >= board.length || j >= board[0].length;
    }

    private class cell {
        private int i;
        private int j;

        public cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }
}
