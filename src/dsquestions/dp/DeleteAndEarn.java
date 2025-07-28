package dsquestions.dp;

import java.util.Arrays;

public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {

        int count[] = new int[10002];
        int dp[] = new int[10002];
        for (int x : nums) {
            count[x]++;
        }
        dp[0] = 0;
        dp[1] = 1 * count[1];
        int max = 0;
        for (int i = 2; i < 10002; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * count[i]);
        }
        return dp[10001];

    }

    public static int deleteAndEarnRec(int[] nums) {

        int count[] = new int[10001];
        int max = 0;
        for (int x : nums) {
            count[x]++;
            max = Math.max(max, x);
        }
        int dp[] = new int[10001];
        Arrays.fill(dp, -1);
        return deleteAndEarnRecUtil(max, count, dp);
    }

    private static int deleteAndEarnRecUtil(int num, int[] count, int[] dp) {
        if (num <= 0) return 0;
        if (dp[num] != -1) return dp[num];
        int c1 = deleteAndEarnRecUtil(num - 2, count, dp) + num * count[num];
        int c2 = deleteAndEarnRecUtil(num - 1, count, dp);
        dp[num] = Math.max(c1, c2);
        return Math.max(c1, c2);
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
    }
}
