package dsquestions.practice;

import java.util.Arrays;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        left[0] = nums[0];
        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[i] = right[i + 1];
            } else if (i == nums.length - 1) {
                res[i] = left[i - 1];
            } else {
                res[i] = left[i - 1] * right[i + 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
