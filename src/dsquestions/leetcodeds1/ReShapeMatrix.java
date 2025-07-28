package dsquestions.leetcodeds1;

import java.util.Arrays;

public class ReShapeMatrix {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int oldR = mat.length;
        int oldC = mat[0].length;
        if (oldR * oldC != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < r * c; i++)
            result[i / c][i % c] = mat[i / oldC][i % oldC];
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2}, {3, 4}
        };
        System.out.println(matrixReshape(mat, 1, 4));
    }
}
