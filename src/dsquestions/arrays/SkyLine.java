package dsquestions.arrays;

import java.util.Arrays;

public class SkyLine {

    public static int maxIncreaseKeepingSkyline(int[][] grid) {

        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            row[i] = Arrays.stream(grid[i]).max().getAsInt();
        }

        for (int i = 0; i < grid[0].length; i++) {
            int max = -1;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(grid[j][i], max);
            }
            col[i] = max;
        }
        int[][] res = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += Math.min(row[i], col[j]) - grid[i][j];
            }
        }
        return sum;

    }

    public static void main(String[] args) {

        int[][] grid = {
                {3, 0, 8, 4},
                {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}
        };
        System.out.println(maxIncreaseKeepingSkyline(grid));

    }

}
