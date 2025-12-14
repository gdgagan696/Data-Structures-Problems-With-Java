package dsquestions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class IsCousin {

    public static boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{root, new TreeNode(-1)});
        int par1 = -1;
        int par2 = -1;
        int dep1 = 0;
        int dep2 = 0;
        int currentDepth = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode[] temp = queue.poll();
                TreeNode val = temp[0];
                TreeNode par = temp[1];
                if (val.val == x) {
                    dep1 = currentDepth;
                    par1 = par.val;
                }
                if (val.val == y) {
                    dep2 = currentDepth;
                    par2 = par.val;
                }
                if (val.left != null) {
                    queue.add(new TreeNode[]{val.left, val});
                }
                if (val.right != null) {
                    queue.add(new TreeNode[]{val.right, val});
                }
            }
            currentDepth++;
        }
        return dep1 == dep2 && par1 != par2;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(isCousins(root, 1, 3));
    }

}


