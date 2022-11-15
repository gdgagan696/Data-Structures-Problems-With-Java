package dsquestions.trees;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodesOptimized(TreeNode root) {
        if (root == null) return 0;

        TreeNode left = root.left, right = root.right;
        int l = 1, r = 1;

        while (left != null) {
            left = left.left;
            ++l;
        }
        while (right != null) {
            right = right.right;
            ++r;
        }

        if (l == r) return (1 << l) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
