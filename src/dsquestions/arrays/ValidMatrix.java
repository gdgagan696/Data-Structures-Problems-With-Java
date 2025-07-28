package dsquestions.arrays;

import java.util.Map;

public class ValidMatrix {
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int index = 0;
        for (int i = 0; i < rowSum.length; i++) {
            if (rowSum[index] > rowSum[i]) {
                index = i;
            }
        }
        int[][] mat = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            mat[i][0] = rowSum[i];
        }
        for (int i = 0; i < mat[0].length; i++) {
            long current = 0;
            for (int j = 0; j < mat.length; j++) {
                current += mat[j][i];
            }
            int row = 0;
            while (current > colSum[i]) {
                long diff = current - colSum[i];
                long shift = Math.min(diff, mat[row][i]);
                mat[row][i] -= (int) shift;
                mat[row][i + 1] += (int) shift;
                current -= shift;
                row++;
            }
        }
        return mat;
    }


    public static void main(String[] args) {
        int[] rowSum = {5, 7, 10};
        int[] colSum = {8, 6, 8};
        System.out.println(restoreMatrix(rowSum, colSum));
    }
}
