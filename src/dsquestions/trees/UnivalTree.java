package dsquestions.trees;

public class UnivalTree {
    public boolean isUnivalTree(TreeNode root) {

        if(root==null)return true;
        if(root.left!=null && root.val!=root.left.val || root.right!=null && root
        .val!=root.right.val)return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);


    }
}
