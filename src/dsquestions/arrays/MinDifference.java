package dsquestions.arrays;

import java.util.Arrays;

public class MinDifference {
    public static int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = nums.length - 4;
        while (i < 4) {
            min = Math.min(min, nums[j] - nums[i]);
            i++;
            j++;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{5, 3, 2, 4}));
    }
}
