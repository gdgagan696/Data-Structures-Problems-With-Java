package dsquestions.trees;

public class BuildTreeFromPreAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);

    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder,int psi,int pei,int isi,int iei) {
        if(isi>iei)return null;

        TreeNode root=new TreeNode(preorder[psi]);
        int i=isi;
        for(;i<iei;i++){
            if(inorder[i]==preorder[psi]){
                break;
            }
        }
        int countLeftSubtree=i-isi;
        root.left=buildTreeHelper(preorder,inorder,psi+1,psi+countLeftSubtree,isi,i-1);
        root.right=buildTreeHelper(preorder,inorder,psi+countLeftSubtree+1,pei,i+1,iei);
        return root;

    }
}
