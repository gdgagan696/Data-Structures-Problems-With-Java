package dsquestions.trees;

public class SumRootToLeaf2 {
    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        sumNumbers(root, "", res);
        return res[0];

    }

    public static void sumNumbers(TreeNode root, String num, int[] res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res[0] += Integer.parseInt(num+root.val);
            return;
        }
        sumNumbers(root.left, num + root.val + "", res);
        sumNumbers(root.right, num + root.val + "", res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }
}
