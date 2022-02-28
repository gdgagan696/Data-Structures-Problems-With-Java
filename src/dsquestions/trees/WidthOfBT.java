package dsquestions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBT {

    class TreeInfo {
        TreeNode node;
        int index;

        public TreeInfo(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(root, 0));
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxWidth = Math.max(size, maxWidth);
            int currentLevelStart = 0;
            int currentLevelEnd = 0;
            for (int i = 0; i < size; i++) {
                TreeInfo treeInfo = queue.poll();
                TreeNode node = treeInfo.node;
                int index = treeInfo.index;
                if (i == 0) {
                    currentLevelStart = index;
                }
                if (i == size - 1) {
                    currentLevelEnd = index;
                }
                if (node.left != null) {
                    queue.add(new TreeInfo(node.left, 2 * index + 1));
                }
                if (node.right != null) {
                    queue.add(new TreeInfo(node.right, 2 * index + 2));
                }

            }
            maxWidth = Math.max(maxWidth, currentLevelEnd - currentLevelStart + 1);
        }
        return maxWidth;
    }

    public static void main(String[] args) {
    }
}
