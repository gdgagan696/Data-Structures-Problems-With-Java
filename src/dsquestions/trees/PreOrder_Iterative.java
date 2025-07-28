package dsquestions.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder_Iterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (stack.size()>0){
            TreeNode temp=stack.pop();
            result.add(temp.val);
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }

        }
        return result;

    }
}
