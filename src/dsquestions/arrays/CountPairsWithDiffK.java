package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithDiffK {

    public int countKDifference(int[] nums, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;

    }

    public static int countKDifference2(int[] nums, int k) {

        Map<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int x : nums) {
            int req1 = x - k;
            int req2 = x + k;
            if (hm.containsKey(req1)) {
                count += hm.get(req1);
            }
            if (hm.containsKey(req2)) {
                count += hm.get(req2);
            }
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 1};
        System.out.println(countKDifference2(nums, 1));
    }
}
