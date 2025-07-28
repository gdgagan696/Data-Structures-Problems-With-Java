package dsquestions.backtracking;

import java.util.*;

public class BeautifulSubsets {
    public static int beautifulSubsetsUtil(int[] nums, int i, int k, Map<Integer, Integer> hm) {
        if (i == nums.length) {
            return 1;
        }
        int res = beautifulSubsetsUtil(nums, i + 1, k, hm);
        if (!hm.containsKey(nums[i] - k) && !hm.containsKey(nums[i] + k)) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            res += beautifulSubsetsUtil(nums, i + 1, k, hm);
            hm.put(nums[i], hm.get(nums[i]) - 1);
            if (hm.get(nums[i]) == 0) {
                hm.remove(nums[i]);
            }
        }
        return res;
    }

    public static int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        return beautifulSubsetsUtil(nums, 0, k, hm) - 1;
    }

    public static void main(String[] args) {
        System.out.println(beautifulSubsets(new int[]{2, 4, 6}, 2));
    }

}
