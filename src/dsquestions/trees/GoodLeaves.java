package dsquestions.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GoodLeaves {
    int res = 0;

    public int countPairs(TreeNode root, int distance) {
        countGoodLeaves(root, distance);
        return res;
    }

    private List<Integer> countGoodLeaves(TreeNode root, int distance) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return new ArrayList<>(List.of(1));
        }
        List<Integer> left = countGoodLeaves(root.left, distance);
        List<Integer> right = countGoodLeaves(root.right, distance);
        for (int v1 : left) {
            for (int v2 : right) {
                if (v1 + v2 <= distance) {
                    res++;
                }
            }
        }
        left.addAll(right);
        return left.stream().map(x -> x + 1).collect(Collectors.toList());
    }
}
