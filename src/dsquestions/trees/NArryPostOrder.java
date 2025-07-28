package dsquestions.trees;

import java.util.ArrayList;
import java.util.List;

public class NArryPostOrder {
    public List<Integer> postorder(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        postorderUtil(root,result);
        return result;
    }

    private void postorderUtil(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        for (TreeNode node:root.children){
            postorderUtil(node,result);
        }
        result.add(root.val);
    }
}
