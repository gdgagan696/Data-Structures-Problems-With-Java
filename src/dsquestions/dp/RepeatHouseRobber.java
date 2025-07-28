package dsquestions.dp;

import java.util.Arrays;


public class RepeatHouseRobber {
    public static int rob(int[] nums) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return robUtil(nums, 0, dp);
    }

    private static int robUtil(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int op1 = nums[index] + robUtil(nums, index + 2, dp);
        int op2 = robUtil(nums, index + 1, dp);
        dp[index] = op1 > op2 ? op1 : op2;
        return dp[index];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }
}
