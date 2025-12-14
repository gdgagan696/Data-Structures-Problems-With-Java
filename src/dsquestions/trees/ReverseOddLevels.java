package dsquestions.trees;

public class ReverseOddLevels {

    public static TreeNode reverseOddLevels(TreeNode root) {

        dfs(root.left, root.right, 1);
        return root;
    }

    private static void dfs(TreeNode left, TreeNode right, int level) {

        if (left == null || right == null) {
            return;
        }

        dfs(left.left, right.right, level + 1);
        dfs(left.right, right.left, level + 1);
        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);
        reverseOddLevels(root);
    }

}
