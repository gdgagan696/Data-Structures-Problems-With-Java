package dsquestions.trees;

import java.util.ArrayList;
import java.util.List;

public class NAryPreOrder {

    public List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;


    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        for (TreeNode node : root.children) {
            preorder(node, result);
        }
    }
}
