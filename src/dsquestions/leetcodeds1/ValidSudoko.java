package dsquestions.leetcodeds1;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoko {
    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<board.length;i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }

        for(int j=0;j<board[0].length;j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }
        return true;



    }


}
