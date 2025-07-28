package dsquestions.dp;

public class TargetSum {

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        target = Math.abs(target);
        int total = sum + target;
        if (target > sum || total % 2 == 1) return 0;
        total = total / 2;
        int[][] dp = new int[nums.length + 1][total + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    if (nums[i - 1] == 0) {
                        dp[i][j] = 2 * dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    int val = nums[i - 1];
                    if (j >= val) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - val];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[nums.length][total];

    }


    public static void main(String[] args) {
//        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
//        System.out.println(findTargetSumWays(new int[]{1},2));
        System.out.println(findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
    }
}
