package dsquestions.trees;

import java.util.Objects;

public class GetDirections {
    public static String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        getPath(root, first, startValue);
        getPath(root, second, destValue);
        int i = 0;
        while (i < first.length() && i < second.length()) {
            if (first.charAt(i) != second.charAt(i)) {
                break;
            }
            i++;
        }
        StringBuilder res = new StringBuilder();
        for (int j = i; j < first.length(); j++) {
            res.append("U");
        }
        for (int j = i; j < second.length(); j++) {
            res.append(second.charAt(j));
        }
        return res.toString();
    }

    public static boolean getPath(TreeNode root, StringBuilder path, int value) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        path.append("L");
        if(getPath(root.left, path, value)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        path.append("R");
        if (getPath(root.right, path, value)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        System.out.println(getDirections(root, 3, 6));

    }

}
