package dsquestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        subsetsUtil(nums, 0, new ArrayList<>(), result);
        return result;

    }

    private static void subsetsUtil(int[] nums, int index, ArrayList<Integer> current, List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        subsetsUtil(nums, index + 1, current, result);
        current.remove(current.size() - 1);
        subsetsUtil(nums, index + 1, current, result);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
