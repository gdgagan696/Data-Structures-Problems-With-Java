package dsquestions.trees;

public class CountNodesEqualToAverageOfSubtree {

    public static int averageOfSubtree(TreeNode root) {

        int[] count = new int[1];
        averageOfSubtreeUtil(root, count, 1);
        return count[0];

    }

    private static int[] averageOfSubtreeUtil(TreeNode root, int[] count, int nodes) {

        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = averageOfSubtreeUtil(root.left, count, nodes + 1);
        int[] right = averageOfSubtreeUtil(root.right, count, nodes + 1);
        int sum = left[0] + right[0] + root.val;
        int total = left[1] + right[1] + 1;
        if (sum / total == root.val) {
            count[0]++;
        }
        return new int[]{sum, total};
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(averageOfSubtree(root));
    }

}
