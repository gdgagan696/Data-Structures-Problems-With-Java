package dsquestions;

public class RootToLeafSum_Binary {
	public static class TreeNode {
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

	private static int helper(TreeNode root, int value) {
		if (root == null) {
			return 0;
		}
		value = value << 1;
		value += root.val;
		if (root.left == null && root.right == null) {
			return value;
		}
		return helper(root.left, value) + helper(root.right, value);
	}

	private static int sumRootToLeaf(TreeNode root) {
		return helper(root, 0);
	}

	public static void main(String[] args) {
		
		sumRootToLeaf(new TreeNode());
		
	}

}
