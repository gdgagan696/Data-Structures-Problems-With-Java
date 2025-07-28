package dsquestions.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int matrixMultiplication(int N, int arr[]) {
        int dp[][] = new int[101][101];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return matrixMultiplication(arr, 1, N - 1, dp);
    }

    private static int matrixMultiplication(int[] arr, int i, int j, int[][] dp) {
        if (i >= j) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = matrixMultiplication(arr, i, k, dp) + matrixMultiplication(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, temp);
        }
        dp[i][j] = min;
        return min;
    }
}
