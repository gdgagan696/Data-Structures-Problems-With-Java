package dsquestions.arrays;

import java.util.Arrays;

public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int x = nums[j];
                nums[j] = nums[i];
                nums[i] = x;
                j++;
            }
        }
        return nums;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{1, 2, 3, 4})));
    }
}
