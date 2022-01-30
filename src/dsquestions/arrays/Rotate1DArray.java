package dsquestions.arrays;

import java.util.Arrays;

public class Rotate1DArray {
    public static void rotate_BruteForce(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = last;
        }
    }

    public static void rotate_Optimized(int[] nums, int k) {

        k = k % nums.length;
        int n = nums.length - k - 1;
        reverseArray(nums, 0, n);
        reverseArray(nums, n + 1, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }


    private static void reverseArray(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        rotate_Optimized(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
    }

}
