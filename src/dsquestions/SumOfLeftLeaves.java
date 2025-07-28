package dsquestions;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int item) {
		val = item;
		left = right = null;
	}
}

public class SumOfLeftLeaves {
	TreeNode root;

	private int sumOfLeftLeaves(TreeNode root) {
		int result = 0;

		if (root != null) {
			if (isLeafNode(root.left)) {
				result += root.left.val;
			} else {
				result += sumOfLeftLeaves(root.left);
			}

			result += sumOfLeftLeaves(root.right);
		}
		return result;

	}

	private boolean isLeafNode(TreeNode root) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null)
			return true;

		return false;
	}

	public static void main(String[] args) {
		SumOfLeftLeaves tree = new SumOfLeftLeaves();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(9);
		tree.root.right = new TreeNode(20);
		tree.root.right.left = new TreeNode(15);
		tree.root.right.right = new TreeNode(7);
		System.out.println(tree.sumOfLeftLeaves(tree.root));
	}

}
