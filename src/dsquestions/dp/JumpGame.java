package dsquestions.dp;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        Boolean dp[] = new Boolean[nums.length];
        return canJump(nums, 0, dp);
    }

    private static boolean canJump(int[] nums, int start, Boolean[] dp) {
        if (start == nums.length - 1) return true;
        if (start > nums.length) return false;
        if (dp[start] != null) return dp[start];
        boolean temp = false;
        for (int i = 1; i <= nums[start]; i++) {
            temp = canJump(nums, start + i, dp);
            dp[start] = temp;
            if (temp) {
                break;
            }
        }
        dp[start] = temp;

        return dp[start];
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
