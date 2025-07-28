package dsquestions.arrays;

import java.util.Arrays;

public class MinNumberGame {

    public static int[] numberGame(int[] nums) {

        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 1) {
            nums[i] = nums[i] ^ nums[i + 1];
            nums[i + 1] = nums[i + 1] ^ nums[i];
            nums[i] = nums[i] ^ nums[i + 1];
            i += 2;
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {2, 5, 3};
        System.out.println(Arrays.toString(numberGame(nums)));

    }

}
