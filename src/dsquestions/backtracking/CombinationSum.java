package dsquestions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumUtil(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private static void combinationSumUtil(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        }
        if (target < 0) {
            return;
        }
        for (; index < candidates.length; index++) {
            int num = candidates[index];
            temp.add(num);
            combinationSumUtil(candidates, target - num, result, temp, index);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

}
