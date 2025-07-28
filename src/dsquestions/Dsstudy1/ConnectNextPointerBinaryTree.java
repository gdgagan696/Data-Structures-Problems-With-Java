package dsquestions.Dsstudy1;

import dsquestions.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNextPointerBinaryTree {
    public TreeNode connect(TreeNode root) {
        if (root == null) return root;

        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public TreeNode connect_Iterative(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- != 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (n == 0) {
                    continue;
                }
                TreeNode next = queue.peek();
                cur.next = next;
            }
        }
        return root;
    }
}
