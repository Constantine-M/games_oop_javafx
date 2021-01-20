package ru.job4j.puzzle;

public class Win {
    public static boolean monoHorizontal(int[][] board, int row) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean monoVertical(int[][] board, int column) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 1) {
                return false;
            }
        }
        return true;
    }
    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                if (monoHorizontal(board, i) || monoVertical(board, i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
