package dsquestions.leetcodeds1;

import java.util.*;
import java.util.function.Function;

public class IntersectionArrayII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int x : nums1) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        for (int x : nums2) {
            if (hm.containsKey(x)) {
                result.add(x);
                hm.put(x, hm.get(x) - 1);
                if (hm.get(x) == 0) hm.remove(x);
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));

    }
}
