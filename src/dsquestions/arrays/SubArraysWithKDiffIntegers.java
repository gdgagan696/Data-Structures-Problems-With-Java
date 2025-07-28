package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDiffIntegers {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithMostKDistinct(nums, k) - subarraysWithMostKDistinct(nums, k - 1);
    }

    public static int subarraysWithMostKDistinct(int[] nums, int k) {
        int i = 0, j = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        int res = 0;
        while (j < nums.length) {
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            j++;
            while (hm.size() > k) {
                hm.put(nums[i], hm.get(nums[i]) - 1);
                if (hm.get(nums[i]) == 0) {
                    hm.remove(nums[i]);
                }
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }
}
