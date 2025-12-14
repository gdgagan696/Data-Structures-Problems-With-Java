package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSumRevision {

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        int i = 0;
        while (i < nums.length) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            while (j < nums.length && j < k && k >= 0) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    List<Integer> temp = List.of(nums[i], nums[j], nums[k]);
                    res.add(temp);
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
            i++;
        }
        return res.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

}
