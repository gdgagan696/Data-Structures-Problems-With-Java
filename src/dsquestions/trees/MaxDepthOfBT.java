package dsquestions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBT {
    public int maxDepth(TreeNode root) {

        if(root==null)return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;

    }

    public int maxDepth_BFS(TreeNode root) {

        if(root==null)return 0;

        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int depth=1;
        while (queue.size()>0){
            int size=queue.size();
            depth++;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return depth;

    }
}
