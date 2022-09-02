package dsquestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevel {

	TreeNode root;

	class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int item) {
			val = item;
			left = right = null;
		}
	}

	private static List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			double avg = 0;
			long sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode temp = queue.poll();
				sum += temp.val;
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			avg = (double) sum / size;
			result.add(avg);
		}
		return result;
	}

	public static void main(String[] args) {

		AverageLevel tree = new AverageLevel();
		tree.root = tree.new TreeNode(3);
		tree.root.left = tree.new TreeNode(9);
		tree.root.right = tree.new TreeNode(20);
		tree.root.right.left = tree.new TreeNode(15);
		tree.root.right.right = tree.new TreeNode(7);
		
		System.err.println(averageOfLevels(tree.root));

		tree.root = tree.new TreeNode(2147483647);
		tree.root.left = tree.new TreeNode(2147483647);
		tree.root.right = tree.new TreeNode(2147483647);
		
		System.err.println(averageOfLevels(tree.root));

	}

}
