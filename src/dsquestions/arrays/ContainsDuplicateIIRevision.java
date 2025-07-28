package dsquestions.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateIIRevision {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.putIfAbsent(nums[i], new ArrayList<>());
            hm.get(nums[i]).add(i);
        }
        for (int x : hm.keySet()) {
            if (hm.get(x).size() > 1) {
                List<Integer> indices = hm.get(x);
                int i = 0;
                int j = 1;
                while (i < j && i < indices.size() && j<indices.size()) {
                    if (indices.get(j) - indices.get(i) <= k) {
                        return true;
                    } else {
                        i++;
                        j++;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(nums, 3));
    }

}
