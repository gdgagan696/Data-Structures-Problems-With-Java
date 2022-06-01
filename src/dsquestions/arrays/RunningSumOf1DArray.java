package dsquestions.arrays;

import java.util.Arrays;

public class RunningSumOf1DArray {
    public static int[] runningSum(int[] nums) {

        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1,2,3,4})));
    }
}
