package dsquestions.strings;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0) && searchWord(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, int i, int j, String word, int index) {
        if (index == word.length() - 1) {
            return true;
        }
        board[i][j] -= 65;
        if (i > 0 && board[i - 1][j] == word.charAt(index + 1) && searchWord(board, i - 1, j, word, index + 1)) {
            return true;
        }
        if (j > 0 && board[i][j - 1] == word.charAt(index + 1) && searchWord(board, i, j - 1, word, index + 1)) {
            return true;
        }
        if (i < board.length - 1 && board[i + 1][j] == word.charAt(index + 1) && searchWord(board, i + 1, j, word, index + 1)) {
            return true;
        }
        if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(index + 1) && searchWord(board, i, j + 1, word, index + 1)) {
            return true;
        }
        board[i][j] += 65;
        return false;
    }

}
