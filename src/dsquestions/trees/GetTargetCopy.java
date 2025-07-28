package dsquestions.trees;

import java.util.LinkedList;
import java.util.Queue;

public class GetTargetCopy {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(cloned);
        while (queue.size()>0){
            TreeNode temp=queue.poll();
            if (temp.val==target.val){
                return temp;
            }
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
        return null;

    }
}
