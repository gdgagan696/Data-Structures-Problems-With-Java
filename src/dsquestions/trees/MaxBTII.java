package dsquestions.trees;

public class MaxBTII {

    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode node = insertIntoMaxTree(root, 7);
        System.out.println(node);
    }

}
