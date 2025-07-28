package dsquestions.arrays;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];
        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[right.length - 1];
        int res[] = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i];
            right[nums.length - i - 1] = right[nums.length - i] * nums[nums.length - i - 1];
        }
        res[0] = right[1];
        res[nums.length - 1] = left[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
