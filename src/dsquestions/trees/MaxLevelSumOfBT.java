package dsquestions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumOfBT {

    public int maxLevelSum(TreeNode root) {

        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int current = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                current += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (current > max) {
                max = current;
                res = level;
            }
            level++;
        }
        return res;

    }

}
