package dsquestions.trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumUtil(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void pathSumUtil(TreeNode root, int targetSum, List<Integer> current, List<List<Integer>> result) {

        if (root == null) {
            return;
        }
        if (targetSum - root.val == 0 && root.left == null && root.right == null) {
            current.add(root.val);
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(root.val);
        if (root.left != null) {
            pathSumUtil(root.left, targetSum - root.val, current, result);
            current.remove(current.size() - 1);
        }

        if (root.right != null) {
            pathSumUtil(root.right, targetSum - root.val, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
    }
}
