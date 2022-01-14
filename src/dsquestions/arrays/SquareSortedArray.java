package dsquestions.arrays;

import java.util.Arrays;

public class SquareSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int res[] = new int[nums.length];
        int k = res.length - 1;
        while (i <= j) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[k--] = nums[i] * nums[i];
                i++;
            } else {
                res[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
