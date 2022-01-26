package dsquestions.trees;

import java.util.*;

public class AllElementsInTwoBST {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {


        List<Integer> result = new ArrayList<>();
        if (root1 == null && root2 == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root1 != null) {
            queue.add(root1);
            while (queue.size() > 0) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    result.add(node.val);
                }
            }
        }
        if (root2 != null) {
            queue.add(root2);
            while (queue.size() > 0) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    result.add(node.val);
                }
            }
        }
        Collections.sort(result);
        return result;

    }
}
