package dsquestions.trees;

import java.util.*;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>>result=new ArrayList<>();
        if(root==null)return result;
        Stack<List<Integer>>tempLevelOrder=new Stack<>();
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                temp.add(node.val);
            }
            tempLevelOrder.add(temp);
        }
        while (!tempLevelOrder.isEmpty()){
            result.add(tempLevelOrder.pop());
        }
        return result;
    }

    public static void main(String[]args){

    }
}
