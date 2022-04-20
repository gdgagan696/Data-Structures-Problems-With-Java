package dsquestions.trees;

import java.util.LinkedList;

public class BSTIterator {
    LinkedList<Integer> inorder;

    public BSTIterator(TreeNode root) {
        this.inorder = new LinkedList<>();
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return inorder.removeFirst();
    }

    public boolean hasNext() {
        return inorder.isEmpty();
    }
}
