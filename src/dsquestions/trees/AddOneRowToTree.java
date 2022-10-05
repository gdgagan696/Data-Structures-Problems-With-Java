package dsquestions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentDepth = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (currentDepth == depth - 1) {
                    TreeNode newLeft = new TreeNode(val);
                    TreeNode newRight = new TreeNode(val);
                    newLeft.left = temp.left;
                    newRight.right = temp.right;
                    temp.left = newLeft;
                    temp.right = newRight;
                }
            }
            currentDepth++;
        }
        return root;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        TreeNode newRoot = addOneRow(root, 1, 2);
        System.out.println(newRoot);
    }
}
