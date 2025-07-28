package dsquestions.practice;

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            rotate(nums);
        }
    }

    private static void rotate(int[] nums) {
        int last = nums[nums.length - 1];
        int current = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i + 1];
            nums[i + 1] = current;
            current = temp;
        }
        nums[0] = last;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
