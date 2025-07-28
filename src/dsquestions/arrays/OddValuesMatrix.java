package dsquestions.arrays;

import java.util.Arrays;

public class OddValuesMatrix {

    public static int oddCells(int m, int n, int[][] indices) {

        int[][] mat = new int[m][n];
        for (int[] x : mat) {
            Arrays.fill(x, 0);
        }
        int total = 0;

        for (int[] index : indices) {
            int row = index[0];
            int col = index[1];
            int[] r = mat[row];
            for (int i = 0; i < r.length; i++) {
                r[i]++;
            }
            for (int i = 0; i < m; i++) {
                mat[i][col]++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] % 2 == 1) {
                    total++;
                }
            }
        }
        return total;

    }

    public static void main(String[] args) {

        System.out.println(oddCells(2,3,new int[][]{
                {0,1},{1,1}
        }));
    }

}
