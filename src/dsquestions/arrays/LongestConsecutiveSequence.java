package dsquestions.arrays;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                temp++;
            } else {
                max = Math.max(temp, max);
                temp = 1;
            }
        }
        return Math.max(max, temp);
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
