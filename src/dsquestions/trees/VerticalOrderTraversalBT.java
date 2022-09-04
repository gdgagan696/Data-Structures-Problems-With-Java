package dsquestions.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversalBT {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> m = new TreeMap<>();
        verticalUtil(root, 0, 0, m);
        List<List<Integer>> result = new ArrayList<>();

        while (m.size() > 0) {
            TreeMap<Integer, List<Integer>> tempX = m.pollFirstEntry().getValue();
            List<Integer> list = new ArrayList<>();
            while (tempX.size() > 0) {
                List<Integer> tempY = tempX.pollLastEntry().getValue();
                Collections.sort(tempY);
                list.addAll(tempY);
            }
            result.add(list);
        }

        return result;
    }

    private void verticalUtil(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, List<Integer>>> m) {
        if (root == null) {
            return;
        }
        if (!m.containsKey(x)) {
            m.put(x, new TreeMap<>());
        }

        if (!m.get(x).containsKey(y)) {
            m.get(x).put(y, new ArrayList<>());
        }
        m.get(x).get(y).add(root.val);
        verticalUtil(root.left, x - 1, y - 1, m);
        verticalUtil(root.right, x + 1, y - 1, m);

    }
}
