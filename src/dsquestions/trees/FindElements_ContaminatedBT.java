package dsquestions.trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindElements_ContaminatedBT {
    TreeNode root = null;
    HashSet<Integer> hs;

    public FindElements_ContaminatedBT(TreeNode root) {
        root.val = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        hs.add(0);
        while (queue.size() > 0) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                temp.left.val = 2 * temp.val + 1;
                queue.offer(temp.left);
                hs.add(temp.left.val);
            }
            if (temp.right != null) {
                temp.right.val = 2 * temp.val + 2;
                queue.offer(temp.right);
                hs.add(temp.right.val);
            }
        }
        this.root = root;
    }

    private boolean findHelper(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        boolean l1 = findHelper(root.left, target);
        if (l1) return l1;
        boolean r1 = findHelper(root.right, target);
        return r1;
    }

}
