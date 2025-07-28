package dsquestions.trees;

public class DiameterOfBT {
    public int diameterOfBinaryTree(TreeNode root) {
        int h=height(root);
        int d1=diameterOfBinaryTree(root.left);
        int d2=diameterOfBinaryTree(root.right);
        return Math.max(Math.max(d1,d2),h);

    }

    private int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
}
