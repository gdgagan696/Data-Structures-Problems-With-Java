package dsquestions.trees;

public class Diameter {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height1 = height(root.left);
        int height2 = height(root.right);
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = diameterOfBinaryTree(root.left);
        }
        if (root.right != null) {
            right = diameterOfBinaryTree(root.right);
        }
        return Math.max(height1 + height2, Math.max(left, right));
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
