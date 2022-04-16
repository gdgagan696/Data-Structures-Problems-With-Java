package dsquestions.trees;

public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        convertBSTUtil(root,0);
        return root;

    }

    private int convertBSTUtil(TreeNode root, int sumUpTill) {
        if (root == null) {
            return sumUpTill;
        }
        root.val += convertBSTUtil(root.right, sumUpTill);
        return convertBSTUtil(root.left, root.val);
    }
}
