package dsquestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> maxRows = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int[] rows : matrix) {
            int minRow = Integer.MAX_VALUE;
            for (int row : rows) {
                minRow = Math.min(minRow, row);
            }
            maxRows.add(minRow);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int maxCol = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                maxCol = Math.max(maxCol, matrix[j][i]);
            }
            col.add(maxCol);
        }
        maxRows.retainAll(col);
        return maxRows;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
//        int[][] matrix = {{7, 8}, {1, 2}};
        int[][] matrix = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println(luckyNumbers(matrix));

    }
}
