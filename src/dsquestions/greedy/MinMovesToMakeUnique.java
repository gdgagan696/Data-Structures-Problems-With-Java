package dsquestions.greedy;

import java.util.*;

public class MinMovesToMakeUnique {
    public static int minIncrementForUnique(int[] nums) {
        int minMoves = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                minMoves += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return minMoves;
    }

    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
        System.out.println(minIncrementForUnique(new int[]{2, 2, 2, 1}));
    }

}
