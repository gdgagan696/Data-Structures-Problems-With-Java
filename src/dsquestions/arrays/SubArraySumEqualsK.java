package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int count = 0;
        hm.put(0, 1);
        for (int x : nums) {
            sum += x;
            if (hm.containsKey(sum - k)) {
                count += hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }
}
