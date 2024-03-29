package dsquestions.trees;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    private TreeNode head = new TreeNode(-1);
    private TreeNode temp = head;

    public TreeNode increasingBST(TreeNode root) {

        if (root == null) return root;
        List<TreeNode> result = new ArrayList<>();
        inOrder(root, result);
        for (int i = 0; i < result.size() - 1; i++) {
            result.get(i).left = null;
            result.get(i).right = result.get(i + 1);
        }
        result.get(result.size() - 1).right = result.get(result.size() - 1).left = null;
        return result.get(0);
    }

    public TreeNode increasingBST_Rec(TreeNode root) {
        inOrder(root);
        return head.right;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        temp.right = root;
        root.left = null;
        temp = root;
        inOrder(root.right);
    }

    private static void inOrder(TreeNode root, List<TreeNode> result) {

        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root);
        inOrder(root.right, result);
    }
}
