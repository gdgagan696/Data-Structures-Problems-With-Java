package dsquestions.trees;

public class MaxBinaryTree {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        TreeNode treeNode = constructMaximumBinaryTreeUtil(nums, 0, nums.length - 1);
        return treeNode;

    }

    private static TreeNode constructMaximumBinaryTreeUtil(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }
        int max = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructMaximumBinaryTreeUtil(nums, start, max - 1);
        root.right = constructMaximumBinaryTreeUtil(nums, max + 1, end);
        return root;

    }

    public static void main(String[] args) {

        constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});

    }

}
