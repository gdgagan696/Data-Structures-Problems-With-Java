package dsquestions.practice;

import java.util.Arrays;

public class RemoveElements {
    public static int removeElement(int[] nums, int val) {
        int res = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                res++;
                int x = nums[i];
                nums[i] = nums[j];
                nums[j] = x;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3};
        System.out.println(removeElement(nums1, 3));
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums2, 2));
        System.out.println(Arrays.toString(nums2));
    }

}
