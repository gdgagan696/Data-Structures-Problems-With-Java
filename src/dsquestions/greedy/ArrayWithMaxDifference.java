package dsquestions.greedy;

import java.util.Arrays;

public class ArrayWithMaxDifference {
    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] res = new int[nums.length / 3][3];
        int i = 0;
        int j = 0;
        while (i < nums.length - 2) {
            if (nums[i + 2] - nums[i] <= k) {
                int temp[] = new int[3];
                temp[0] = nums[i];
                temp[1] = nums[i + 1];
                temp[2] = nums[i + 2];
                i += 3;
                res[j++] = temp;
            } else {
                return new int[0][0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)));
        System.out.println(Arrays.toString(divideArray(new int[]{1, 3, 3, 2, 7, 3}, 3)));
    }
}
