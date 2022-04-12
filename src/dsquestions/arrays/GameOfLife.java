package dsquestions.arrays;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {

        int res[][] = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int ones = noOfOnes(board, i, j);
                if (ones < 2 || ones > 3) {
                    res[i][j] = 0;
                } else if (board[i][j] == 0 && ones == 3) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = board[i][j];
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.arraycopy(res[i], 0, board[i], 0, res[i].length);
        }
    }

    private static int noOfOnes(int[][] board, int i, int j) {
        int ones = 0;
        if (isValid(board, i + 1, j) && board[i + 1][j] == 1)
            ones++;
        if (isValid(board, i - 1, j) && board[i - 1][j] == 1)
            ones++;
        if (isValid(board, i, j - 1) && board[i][j - 1] == 1)
            ones++;
        if (isValid(board, i, j + 1) && board[i][j + 1] == 1)
            ones++;
        if (isValid(board, i + 1, j + 1) && board[i + 1][j + 1] == 1)
            ones++;
        if (isValid(board, i - 1, j + 1) && board[i - 1][j + 1] == 1)
            ones++;
        if (isValid(board, i - 1, j - 1) && board[i - 1][j - 1] == 1)
            ones++;
        if (isValid(board, i + 1, j - 1) && board[i + 1][j - 1] == 1)
            ones++;

        return ones;


    }


    private static boolean isValid(int[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}
        };
        gameOfLife(board);
    }
}
