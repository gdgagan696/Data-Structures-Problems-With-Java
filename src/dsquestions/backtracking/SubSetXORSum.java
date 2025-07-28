package dsquestions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSetXORSum {
    public static int subsetXORSum(int[] nums) {
        return subsetXORSum(nums, 0, 0);

    }

    public static int subsetXORSum(int[] nums, int i, int sum) {
        if (i == nums.length) {
            return sum;
        }
        return subsetXORSum(nums, i + 1, sum) + subsetXORSum(nums, i + 1, sum ^ nums[i]);

    }

    public static int subsetXORSum_Bit(int[] nums) {
        int n = 1 << nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int k = 0;
            int temp = i;
            int tempXor = 0;
            while (temp > 0) {
                if ((temp & 1) > 0) {
                    tempXor ^= nums[k];
                }
                k++;
                temp = temp >> 1;
            }
            total += tempXor;
        }
        return total;

    }


    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1, 3}));
        System.out.println(subsetXORSum_Bit(new int[]{1, 3}));
    }
}
