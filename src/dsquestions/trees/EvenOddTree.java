package dsquestions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            int prev = -1;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(level % 2 == 0) {
                    if (temp.val % 2 == 0) {
                        return false;
                    } else if (prev != -1 && prev >= temp.val) {
                        return false;
                    }
                } else {
                    if (temp.val % 2 != 0) {
                        return false;
                    } else if (prev != -1 && prev <= temp.val) {
                        return false;
                    }
                }
                prev = temp.val;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(3);
        root.right.left=new TreeNode(7);
        System.out.println(isEvenOddTree(root));
    }


}
