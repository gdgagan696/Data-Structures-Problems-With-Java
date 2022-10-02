package dsquestions.dp;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {

    private static final int mod = 1000_000_000 + 7;

    public static int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int temp[] : dp) {
            Arrays.fill(temp, -1);
        }
        numRollsToTargetUtil(n, k, target, dp);
        return dp[n][target];
    }

    private static int numRollsToTargetUtil(int n, int k, int target, int[][] dp) {
        if (target == 0 && n == 0) {
            return 1;
        }
        if (target < 0 || n < 0) {
            return 0;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = ans + numRollsToTargetUtil(n - 1, k, target - i, dp);
            ans = ans % mod;
        }
        return dp[n][target] = ans;
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(30, 30, 500));
    }


}
