package dsquestions.practice;

public class JumpGameII {
    public static int jump(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        return jumpUtil(nums, 0, dp);
    }

    private static int jumpUtil(int[] nums, int index, Integer[] dp) {
        if (index == nums.length - 1) {
            return 0;
        }
        if (index >= nums.length) {
            return -1;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            int temp = jumpUtil(nums, index + i, dp);
            if (temp >= 0 && temp < min) {
                min = 1 + temp;
            }
        }
        return dp[index] = min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(jump(nums));
    }
}
