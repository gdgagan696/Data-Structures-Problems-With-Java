package dsquestions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueensI {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] board = new int[n][n];
        solveNQueens(n, board, result, 0);
        return result;
    }

    private static void solveNQueens(int n, int[][] board, List<List<String>> result, int row) {

        if (row >= n) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 0) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                    temp.add(sb.toString());
                }
            }
            result.add(temp);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                board[row][j] = 1;
                solveNQueens(n, board, result, row + 1);
                board[row][j] = 0;
            }

        }

    }

    private static boolean isSafe(int board[][], int row, int col, int n) {

        /* Check this row on left side */
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        /* Check upper diagonal on left side */
        int x = row;
        int y = col;
        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1) return false;
            x--;
            y--;
        }
        /* Check upper diagonal on right side */
        x = row;
        y = col;
        while (x >= 0 && y < n) {
            if (board[x][y] == 1) return false;
            x--;
            y++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

}
