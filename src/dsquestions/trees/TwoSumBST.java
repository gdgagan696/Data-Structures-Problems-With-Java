package dsquestions.trees;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {

        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        boolean left = findTarget(root.left, k);
        if (!left) {
            return findTarget(root.right, k);
        }
        return true;
    }
}
