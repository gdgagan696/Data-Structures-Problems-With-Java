package dsquestions.arrays;

public class AvailableCapturesForRook {

    public static int numRookCaptures(char[][] board) {

        int row = 0, col = 0;
        int count = 0;
        outer:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    break outer;
                }
            }
        }
        int tempCol = col;
        while (tempCol >= 0) {
            if (board[row][tempCol] == 'B') {
                break;
            }
            if (board[row][tempCol] == 'p') {
                count++;
                break;
            }
            tempCol--;
        }
        tempCol = col;
        while (tempCol < board[0].length) {
            if (board[row][tempCol] == 'B') {
                break;
            } else if (board[row][tempCol] == 'p') {
                count++;
                break;
            }
            tempCol++;
        }
        int tempRow = row;
        while (tempRow >= 0) {
            if (board[tempRow][col] == 'B') {
                break;
            }
            if (board[tempRow][col] == 'p') {
                count++;
                break;
            }
            tempRow--;
        }
        tempRow = row;
        while (tempRow < board.length) {
            if (board[tempRow][col] == 'B') {
                break;
            } else if (board[tempRow][col] == 'p') {
                count++;
                break;
            }
            tempRow++;
        }
        return count;
    }

    public static void main(String[] args) {

        char[][] board =
                {
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', 'p', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'}
                };

        System.out.println(numRookCaptures(board));
    }

}
