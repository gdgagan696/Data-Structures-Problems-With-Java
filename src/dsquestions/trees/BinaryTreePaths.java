package dsquestions.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> allPaths = new ArrayList<>();
        binaryTreePathsUtil(root, allPaths, new ArrayList<>());
        return allPaths;
    }

    private static void binaryTreePathsUtil(TreeNode root, List<String> allPaths, List<String> currentPath) {

        if (root == null) {
            return;
        }
        currentPath.add(root.val + "");
        if (root.left == null && root.right == null) {
            allPaths.add(String.join("->", currentPath));
            currentPath.remove(currentPath.size() - 1);
            return;
        }
        binaryTreePathsUtil(root.left, allPaths, currentPath);
        binaryTreePathsUtil(root.right, allPaths, currentPath);
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));

    }

}
