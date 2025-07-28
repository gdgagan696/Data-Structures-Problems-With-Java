package dsquestions.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder_Iterative {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode current=root;
        while (current!=null || stack.size()>0){
            while (current!=null){
                stack.push(current);
                current=current.left;
            }
            TreeNode temp=stack.pop();
            result.add(temp.val);
            current=temp.right;
        }
        return result;

    }
}
