package dsquestions.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNode {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> result = new ArrayList<>();
        root = delNodesUtil(root, set, result);
        if (root != null) {
            result.add(root);
        }
        return result;
    }

    private TreeNode delNodesUtil(TreeNode root, Set<Integer> set, List<TreeNode> result) {
        if (root == null) {
            return null;
        }
        root.left = delNodesUtil(root.left, set, result);
        root.right = delNodesUtil(root.right, set, result);
        if (set.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }
        return root;
    }
}
