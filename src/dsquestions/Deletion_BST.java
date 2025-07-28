package dsquestions;

public class Deletion_BST {
	TreeNode root;

	class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	private static int minValue(TreeNode root) {
		int min = root.val;
		while (root.left != null) {
			min = root.left.val;
			root = root.left;
		}
		return min;
	}

	private static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				root.val = minValue(root.right);
				root.right = deleteNode(root.right, root.val);
			}
		}

		return root;

	}

	private static void printTree(TreeNode root) {
		if (root.left != null) {
			System.out.print(root.left.val + "-->");
		} else {
			System.out.print("__");
		}
		System.out.print(root.val);
		if (root.right != null) {
			System.out.print("<--" + root.right.val);
		} else {
			System.out.print("<--.");
		}

		System.out.println();

		if (root.left != null) {
			printTree(root.left);
		}

		if (root.right != null) {
			printTree(root.right);
		}
	}

	public static void main(String[] args) {
		Deletion_BST tree = new Deletion_BST();
		tree.root = tree.new TreeNode(5);
		tree.root.left = tree.new TreeNode(3);
		tree.root.right = tree.new TreeNode(6);
		tree.root.left.left = tree.new TreeNode(2);
		tree.root.left.right = tree.new TreeNode(4);
		tree.root.right.right = tree.new TreeNode(7);

		System.out.println("Before Deletion:");
		printTree(tree.root);

		deleteNode(tree.root, 3);

		System.out.println("After Deletion:");
		printTree(tree.root);

	}

}
