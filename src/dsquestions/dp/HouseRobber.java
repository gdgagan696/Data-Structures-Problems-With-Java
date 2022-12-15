package dsquestions.dp;

import java.util.Arrays;

public class HouseRobber {
    public static int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return robUtil(nums, dp, 0);
    }

    private static int robUtil(int[] nums, int[] dp, int i) {
        if (i >= nums.length) return 0;
        if (dp[i] != -1) return dp[i];

        int max = Math.max(nums[i] + robUtil(nums, dp, i + 2), robUtil(nums, dp, i + 1));
        dp[i] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }
}
