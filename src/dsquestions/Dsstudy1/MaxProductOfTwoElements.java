package dsquestions.Dsstudy1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MaxProductOfTwoElements {
    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length-1;
        int x=nums[len];
        int y=nums[len-1];
        return (x - 1) * (y - 1);
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1,5,4,5}));
    }
}
