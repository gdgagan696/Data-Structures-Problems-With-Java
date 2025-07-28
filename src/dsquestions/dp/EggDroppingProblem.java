package dsquestions.dp;

import java.util.Arrays;

public class EggDroppingProblem {
    public static int superEggDrop(int k, int n) {

        int dp[][] = new int[k + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return eggDrop(k, n, dp);
    }

    public static int eggDrop(int k, int n, int dp[][]) {
        if (n == 1) return n;
        if (k == 1) return n;
        if (dp[k][n] != -1) {
            return dp[k][n];
        }


        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int temp = Math.max(eggDrop(k - 1, i - 1, dp), eggDrop(k, n - i, dp));
            min = Math.min(temp, min);
        }
        dp[k][n] = min + 1;
        return dp[k][n];
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(1, 2));
        System.out.println(superEggDrop(2, 6));
    }
}
