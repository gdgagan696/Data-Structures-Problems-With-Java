package dsquestions.trees;

public class SumOfLeftLeaves {
    int result=0;
    private void sumOfLeftLeavesHelper(TreeNode root) {

        if(root==null){
            return;
        }
        if(isLeafNode(root.left)){
            result+=root.left.val;

        }
        sumOfLeftLeavesHelper(root.left);
        sumOfLeftLeavesHelper(root.right);


    }
    private boolean isLeafNode(TreeNode root){
        if(root==null) return false;

        if(root.left==null && root.right==null)return true;

        return false;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeavesHelper(root);
        return result;
    }

}
