package dsquestions.arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxFrequency {

    public int maxFrequencyElements(int[] nums) {

        Map<Integer, Integer> hm = new HashMap<>();
        int res = 0;
        for (int x : nums) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        int max = Collections.max(hm.values());
        for (int key : hm.keySet()) {
            if (hm.get(key) == max) {
                res += max;
            }
        }
        return res;

    }

}
