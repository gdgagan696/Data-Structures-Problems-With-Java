package dsquestions.trees;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        boolean ans = hasPathSum(root.left, targetSum - root.val);
        if (ans) return ans;
        ans = hasPathSum(root.right, targetSum - root.val);
        return ans;

    }
}
