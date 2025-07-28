package dsquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AddOneRow {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private static TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode newRoot = new AddOneRow().new TreeNode(v);
			newRoot.left = root;
			root = newRoot;
			return newRoot;
		}
		TreeMap<Integer, List<TreeNode>> depthMap = new TreeMap<>();
		fillMap(root, 1, depthMap);

		List<TreeNode> depthNodes = depthMap.get(d - 1);
		for (TreeNode treeNode : depthNodes) {
			TreeNode newLeft = new AddOneRow().new TreeNode(v);
			TreeNode newRight = new AddOneRow().new TreeNode(v);
			newLeft.left = treeNode.left;
			newRight.right = treeNode.right;
			treeNode.left = newLeft;
			treeNode.right = newRight;
		}
		return root;

	}

	private static void fillMap(TreeNode root, int depth, TreeMap<Integer, List<TreeNode>> depthMap) {
		if (root == null) {
			return;
		}
		if (depthMap.containsKey(depth)) {
			depthMap.get(depth).add(root);
		} else {
			List<TreeNode> temp = new ArrayList<>();
			temp.add(root);
			depthMap.put(depth, temp);
		}
		fillMap(root.left, depth + 1, depthMap);
		fillMap(root.right, depth + 1, depthMap);

	}

	public static void main(String[] args) {
		addOneRow(null,1,2);

	}

}
