package dsquestions.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PrintBT {

    public static List<List<String>> printTree(TreeNode root) {

        int height = height(root);
        int row = height + 1;
        int col = (int) (Math.pow(2, height + 1) - 1);
        String[][] matrix = new String[row][col];
        matrix[0][(col - 1) / 2] = root.val+"";
        dfs(root, 0, (col - 1) / 2, matrix, height);
        List<List<String>> res = new ArrayList<>();

        for (String[] r : matrix) {
            List<String>temp=new ArrayList<>();
            for(String c:r) {
                String val=c==null?"":c+"";
                temp.add(val);
            }
            res.add(temp);
        }
        return res;
    }

    private static void dfs(TreeNode root, int row, int col, String[][] matrix, int height) {

        if (root == null) {
            return;
        }
        if (root.left != null) {
            int leftRow = row + 1;
            int leftCol = col - (int) (Math.pow(2, height - row - 1));
            matrix[leftRow][leftCol] = root.left.val+"";
            dfs(root.left, leftRow, leftCol, matrix, height);
        }
        if (root.right != null) {
            int rightRow = row + 1;
            int rightCol = col + (int) (Math.pow(2, height - row - 1));
            matrix[rightRow][rightCol] = root.right.val+"";
            dfs(root.right, rightRow, rightCol, matrix, height);
        }

    }

    private static int height(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        System.out.println(printTree(root));
    }
}
