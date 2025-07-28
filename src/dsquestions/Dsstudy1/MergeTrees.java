package dsquestions.Dsstudy1;

import dsquestions.trees.TreeNode;

public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)return null;
        TreeNode root=new TreeNode();
        root.val=(root1==null?0:root1.val)+(root2==null?0:root2.val);
        TreeNode left1=root1!=null && root1.left!=null?root1.left:null;
        TreeNode left2=root2!=null && root2.left!=null?root2.left:null;
        root.left=mergeTrees(left1,left2);

        TreeNode right1=root1!=null && root1.right!=null?root1.right:null;
        TreeNode right2=root2!=null && root2.right!=null?root2.right:null;
        root.right=mergeTrees(right1,right2);

        return root;


    }
}
