package dsquestions.trees;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p!=null && q==null){
            return false;
        }
        if(p==null && q!=null){
            return false;
        }
        boolean left=isSameTree(p.left,q.left);
        if(!left){
            return false;
        }
        boolean right=isSameTree(p.right,q.right);
        if(!right){
            return false;
        }
        return left && right && p.val==q.val;
    }
}
