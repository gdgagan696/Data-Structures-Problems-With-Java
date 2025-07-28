package dsquestions.trees;

public class SumRootToLeaf {
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {

        sumRootToLeaf(root,"");
        return sum;
    }

    private void sumRootToLeaf(TreeNode root, String num) {

        if (root==null)return;
        if(root.left==null && root.right==null){
            num+=root.val+"";
            sum+=Integer.parseInt(num,2);
            return;
        }
        sumRootToLeaf(root.left,num+""+root.val+"");
        sumRootToLeaf(root.right,num+""+root.val+"");

    }
}
