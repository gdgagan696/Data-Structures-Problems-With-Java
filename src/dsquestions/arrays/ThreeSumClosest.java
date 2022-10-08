package dsquestions.arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[low] + nums[high] + nums[i];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    high--;
                } else if (sum < target) {
                    low++;
                }
                int diff = Math.abs(target - sum);
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
    }
}
