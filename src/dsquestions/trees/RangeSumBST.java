package dsquestions.trees;

public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int n = 0;
        if (root.val >= low && root.val <= high) n = root.val;
        n += rangeSumBST(root.left, low, high);
        n += rangeSumBST(root.right, low, high);
        return n;

    }
}
