package dsquestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {


    private static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        int maj1 = -1;
        int maj2 = -1;
        int count1 = 0;
        int count2 = 0;
        int max = nums.length / 3;
        for (int i = 0; i < nums.length; i++) {
            if (maj1 == nums[i]) {
                count1++;
            } else if (maj2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                maj1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                maj2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }

        }
        int c1 = 0;
        int c2 = 0;
        for (int x : nums) {
            if (x == maj1) c1++;
            else if (x == maj2) c2++;
        }
        if (c1 > max) result.add(maj1);
        if (c2 > max) result.add(maj2);
        return result;

    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 1, 1, 3, 1, 4, 5, 6}));

    }
}
