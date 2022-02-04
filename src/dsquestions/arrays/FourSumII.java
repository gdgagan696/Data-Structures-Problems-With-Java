package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                hm.put(nums1[i] + nums2[j], hm.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (hm.containsKey(-(nums3[i] + nums4[j]))) {
                    count += hm.get(-(nums3[i] + nums4[j]));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2};
        int nums2[] = {-2, -1};
        int nums3[] = {-1, 2};
        int nums4[] = {0, 2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
