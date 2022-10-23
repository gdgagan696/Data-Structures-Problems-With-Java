package dsquestions.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMismatch {

    private static int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        int result[] = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (!hm.containsKey(i)) {
                result[1] = i;
            } else if (hm.get(i) > 1) {
                result[0] = i;
            }

        }
        return result;

    }

    public static void main(String[] args) {
        System.err.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));

    }

}
