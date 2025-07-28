package dsquestions.arrays;

public class MinSwaps {
    public int minSwaps(int[] nums) {
        int window = 0;
        int n = nums.length;
        for (int x : nums) {
            if (x == 1) {
                window++;
            }
        }
        int i = 0;
        int j = 0;
        int current = 0;
        int max = Integer.MIN_VALUE;
        while (j < 2 * n) {
            if (nums[j%n] == 1) {
                current++;
            }
            if (j - i + 1 > window) {
                current -= nums[i%n];
                i++;
            }
            max = Math.max(current, max);
            j++;
        }
        return window-max;
    }

}
