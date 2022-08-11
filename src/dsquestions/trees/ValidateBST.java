package dsquestions.trees;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        boolean checkLeft = isValidBST(root.left, min, root.val);
        boolean checkRight = isValidBST(root.right, root.val, max);

        return checkLeft && checkRight;
    }
}
