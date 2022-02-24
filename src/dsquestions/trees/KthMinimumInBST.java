package dsquestions.trees;

public class KthMinimumInBST {
    public int kThMinimumInBST(TreeNode root, int k) {
        int kArray[] = new int[1];
        kArray[0] = k;
        return kthMinimumBSTUtil(root, kArray).val;
    }

    private TreeNode kthMinimumBSTUtil(TreeNode root, int[] kArray) {
        if (root == null) {
            return null;
        }
        TreeNode node = kthMinimumBSTUtil(root.left, kArray);
        kArray[0] = kArray[0] - 1;
        if (kArray[0] == 0) {
            return root;
        }
        if (node != null) return node;
        return kthMinimumBSTUtil(root.right, kArray);
    }
}
