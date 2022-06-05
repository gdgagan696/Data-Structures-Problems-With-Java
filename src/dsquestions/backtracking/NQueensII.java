package dsquestions.backtracking;

public class NQueensII {

    public static int totalNQueens(int n) {
        int[][] board = new int[n][n];
        return totalNQueens(n, board, 0);

    }

    private static int totalNQueens(int n, int[][] board, int row) {

        if (row >= n) {
            return 1;
        }
        int total = 0;
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                board[row][j] = 1;
                total += totalNQueens(n, board, row + 1);
                board[row][j] = 0;
            }
        }
        return total;
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
        System.out.println(totalNQueens(4));
    }

}
