package dsquestions.dp;

public class MinimumFallingPathSum {


    public int minFallingPathSum(int[][] matrix) {

        Integer[][] dp = new Integer[matrix.length + 1][matrix[0].length + 1];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            ans = Math.min(ans, minFallingPathSumUtil(matrix, 0, i, dp));
        }
        return ans;
    }

    private int minFallingPathSumUtil(int[][] matrix, int i, int j, Integer[][] dp) {

        if (j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == matrix.length - 1) {
            dp[i][j] = matrix[i][j];

        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int op1 = minFallingPathSumUtil(matrix, i + 1, j - 1, dp);
        int op2 = minFallingPathSumUtil(matrix, i + 1, j + 1, dp);
        int op3 = minFallingPathSumUtil(matrix, i + 1, j, dp);
        dp[i][j] = Math.min(op1, Math.min(op2, op3)) + matrix[i][j];

        return dp[i][j];
    }
}
