package dsquestions.trees;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        postorderTraversalUtil(root,result);
        return result;
    }

    private void postorderTraversalUtil(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        postorderTraversalUtil(root.left,result);
        postorderTraversalUtil(root.right,result);
        result.add(root.val);
    }

}
