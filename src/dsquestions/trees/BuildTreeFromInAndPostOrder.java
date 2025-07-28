package dsquestions.trees;

public class BuildTreeFromInAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder,postorder,0,inorder.length-1,0,inorder.length-1);

    }

    public TreeNode buildTreeHelper(int[] inorder, int[] postorder,int isi,int iei,int psi,int pei) {
        if(isi>iei)return null;

        TreeNode root=new TreeNode(postorder[pei]);
        int i=isi;
        for(;i<iei;i++){
            if(inorder[i]==postorder[pei]){
                break;
            }
        }
        int countLeftSubtree=i-isi;
        root.left=buildTreeHelper(inorder,postorder,isi,i-1,psi,psi+countLeftSubtree-1);
        root.right=buildTreeHelper(inorder,postorder,i+1,iei,psi+countLeftSubtree,pei-1);
        return root;

    }
}
