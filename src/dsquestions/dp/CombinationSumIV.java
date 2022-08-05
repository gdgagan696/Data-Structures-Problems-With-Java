package dsquestions.dp;

import java.util.Arrays;

public class CombinationSumIV {

    public static int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);
        int asn = combinationSum4Util(nums, target, 0, dp);
        return asn;
    }

    private static int combinationSum4Util(int[] nums, int target, int index, int[] dp) {
        if (target == 0) {
            return 1;
        }
        if (index >= nums.length || target < 0) {
            return 0;
        }
        if (dp[target] != -1) return dp[target];
        int op1 = combinationSum4Util(nums, target - nums[index], 0, dp);
        int op2 = combinationSum4Util(nums, target, index + 1, dp);
        dp[target] = op1 + op2;
        return op1 + op2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(combinationSum4(nums, 4));
    }
}
