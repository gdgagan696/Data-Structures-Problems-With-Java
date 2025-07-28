package dsquestions.trees;

import java.util.ArrayList;
import java.util.List;

public class NAryPostOrder {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    public void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        for (TreeNode node : root.children) {
            postOrder(node, result);
        }
        result.add(root.val);
    }
}
