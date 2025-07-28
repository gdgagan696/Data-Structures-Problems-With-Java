package dsquestions.leetcodeds1;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;
        for (int i = 0; i < nums.length; i++) {
            localMax += nums[i];
            globalMax = Math.max(localMax, globalMax);
            if (localMax < 0) {
                localMax = 0;
            }
        }
        return globalMax;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
