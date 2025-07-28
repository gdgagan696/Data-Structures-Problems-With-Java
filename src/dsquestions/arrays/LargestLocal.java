package dsquestions.arrays;


import java.util.Arrays;
import java.util.Map;

public class LargestLocal {
    public static int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[i][j] = getMax(grid, i, j);
            }
        }
        return res;
    }

    private static int getMax(int[][] grid, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int m = i; m < i + 3; m++) {
            for (int n = j; n < j + 3; n++) {
                max = Math.max(max, grid[m][n]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {9, 9, 8, 1},
                {5, 6, 2, 6},
                {8, 2, 6, 4},
                {6, 2, 2, 2}
        };
        System.out.println(Arrays.toString(largestLocal(grid)));
    }
}
