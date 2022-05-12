package dsquestions.backtracking;

import java.util.*;

public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {

        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteUniqueUtil(nums, new ArrayList<>(), result, visited, new HashSet<>());
        return result;

    }

    private static void permuteUniqueUtil(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] visited, Set<List<Integer>> visitedSet) {

        if (current.size() == nums.length && !visitedSet.contains(current)) {
            visitedSet.add(current);
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                current.add(nums[i]);
                visited[i] = true;
                permuteUniqueUtil(nums, current, result, visited, visitedSet);
                visited[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
}
