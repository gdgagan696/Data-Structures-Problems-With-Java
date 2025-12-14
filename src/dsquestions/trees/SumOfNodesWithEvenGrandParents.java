package dsquestions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfNodesWithEvenGrandParents {

    public static int sumEvenGrandparent(TreeNode root) {

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{root, new TreeNode(-1)});
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode[] treeNode = queue.poll();
            TreeNode node = treeNode[0];
            TreeNode par = treeNode[1];
            if (node.left != null) {
                queue.add(new TreeNode[]{node.left, node});
                if (par.val % 2 == 0) {
                    sum += node.left.val;
                }
            }
            if (node.right != null) {
                queue.add(new TreeNode[]{node.right, node});
                if (par.val % 2 == 0) {
                    sum += node.right.val;
                }
            }
        }
        return sum;

    }

    public static void main(String[] args) {

    }

}
