package dsquestions.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CousinsInBT {

    public static TreeNode replaceValueInTree(TreeNode root) {

        Map<Integer, Integer> hm = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum=0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum+=node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            hm.put(level,levelSum);
            level++;
        }
        queue.add(root);
        root.val = 0;
        level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = hm.getOrDefault(level,0);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int siblingSum = 0;
                if (node.left != null) {
                    siblingSum += node.left.val;
                }
                if (node.right != null) {
                    siblingSum += node.right.val;
                }
                if (node.left != null) {
                    node.left.val = levelSum - siblingSum;
                    queue.add(node.left);

                }
                if (node.right != null) {
                    node.right.val = levelSum - siblingSum;
                    queue.add(node.right);

                }
            }
            level++;
        }
        return root;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(7);
        replaceValueInTree(root);

    }

}
