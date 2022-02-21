package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int x : nums) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        int maj = nums.length / 2;
        for (int x : hm.keySet()) {
            if (hm.get(x) > maj) {
                return x;
            }
        }
        return -1;

    }


    public static int majorityElementUsingMooreVoting(int[] nums) {
        int majorityElement = getMajorityCandidate(nums);
        int count = 0;
        for (int x : nums) {
            if (x == majorityElement) count++;
        }
        return count >= nums.length / 2 ? majorityElement : -1;
    }

    private static int getMajorityCandidate(int[] nums) {
        int majorityElement = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (majorityElement == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majorityElement = nums[i];
                count = 1;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElementUsingMooreVoting(new int[]{2, 2, 1, 1, 1, 2, 2}));


    }
}
