package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < nums.length) {
                if (j != i + 1 && nums[j - 1] == nums[j]) {
                    j++;
                    continue;
                }
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    long sum = nums[i] + nums[j];
                    sum+=nums[m] + nums[n];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        do {
                            m++;
                        } while (m < n && nums[m - 1] == nums[m]);
                        do {
                            n--;
                        } while (m < n && nums[n + 1] == nums[n]);
                    } else if (sum > target) {
                        n--;
                    } else {
                        m++;
                    }
                }
                j++;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));
    }

}
