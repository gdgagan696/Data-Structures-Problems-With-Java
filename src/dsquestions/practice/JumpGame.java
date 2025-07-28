package dsquestions.practice;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return canJumpUtil(nums, 0, dp);
    }

    private static boolean canJumpUtil(int[] nums, int index, Boolean[] dp) {
        if (index == nums.length - 1) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        boolean temp = false;
        for (int i = 1; i <= nums[index]; i++) {
            temp = canJumpUtil(nums, index + i, dp);
            if (temp) {
                break;
            }
        }
        dp[index] = temp;
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}
