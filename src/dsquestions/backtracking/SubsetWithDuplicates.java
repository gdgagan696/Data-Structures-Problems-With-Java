package dsquestions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, result, new ArrayList<>());
        return result;
    }

    private static void subsetsWithDup(int[] nums, int index, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i=index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i]) continue;
            temp.add(nums[i]);
            subsetsWithDup(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[]args){
        System.out.println(subsetsWithDup(new int[]{1,2,2,}));
    }
}
