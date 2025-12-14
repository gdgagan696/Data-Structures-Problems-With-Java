package dsquestions.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinOperations {

    public static int minimumOperations(TreeNode root) {

        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int total = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                temp.add(node.val);
            }
            levelOrder.add(temp);
        }

        for (int i = 1; i < levelOrder.size(); i++) {
            total += minOps(levelOrder.get(i));
        }
        return total;
    }

    private static int minOps(List<Integer> list) {

        List<Integer> cloned = new ArrayList<>(list);
        Collections.sort(cloned);
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            pos.put(list.get(i), i);
        }
        int swaps = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(cloned.get(i))) {
                int ind = pos.get(cloned.get(i));
                int val1 = list.get(i);
                int val2 = list.get(ind);
                pos.put(val1, ind);
                pos.put(val2, i);
                list.set(ind, val1);
                list.set(i, val2);

                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(minimumOperations(root));
    }


}
