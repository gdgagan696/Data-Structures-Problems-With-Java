package dsquestions.dp;

import java.util.Arrays;

public class CherryPickUpII {
    public static int cherryPickup(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int outArr[][] : dp) {
            for (int[] innArr : outArr) {
                Arrays.fill(innArr, -1);
            }
        }
        return cherryPickup(grid, 0, 0, n - 1, dp);
    }

    private static int cherryPickup(int[][] grid, int row, int robC1, int robC2, int[][][] dp) {

        if (row == grid.length) return 0;
        if (dp[row][robC1][robC2] != -1) return dp[row][robC1][robC2];
        int ans = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newC1 = robC1 + i;
                int newC2 = robC2 + j;
                if (newC1 >= 0 && newC1 < grid[0].length && newC2 >= 0 && newC2 < grid[0].length) {
                    ans = Math.max(ans, cherryPickup(grid, row+1, newC1, newC2, dp));
                }
            }
        }
        ans = ans + (robC1 == robC2 ? grid[row][robC1] : grid[row][robC1] + grid[row][robC2]);
        dp[row][robC1][robC2] = ans;
        return ans;

    }

    public static void main(String[]args){
        int[][]grid={
                {3,1,1},{2,5,1},{1,5,5},{2,1,1}
        };
        System.out.println(cherryPickup(grid));
    }
}
