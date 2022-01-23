package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        HashSet<List<Integer>> hashSet = new HashSet<>();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<int[]> temp = twoSum(nums, i + 1, -1 * nums[i]);
            if (!temp.isEmpty()) {
                for (int[] x : temp) {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[x[0]]);
                    integers.add(nums[x[1]]);
                    if (!hashSet.contains(integers)) {
                        result.add(integers);
                        hashSet.add(integers);
                    }
                }

            }
        }
        return result;
    }

    private static List<int[]> twoSum(int[] nums, int i, int target) {
        int low = i;
        int high = nums.length - 1;


        List<int[]> result = new ArrayList<>();
        while (low < high) {

            int sum = nums[low] + nums[high];
            if (sum == target) {
                int[] ans = new int[2];
                Arrays.fill(ans, -1);
                ans[0] = low;
                ans[1] = high;
                result.add(ans);
                int lowTemp = nums[low];
                int highTemp = nums[high];
                while (low < high) {
                    low++;
                    high--;
                    if (lowTemp != nums[low] || highTemp != nums[high]) {
                        break;
                    }

                }
            } else if (sum > target) {
                high--;
            } else if (sum < target) {
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));

    }
}
