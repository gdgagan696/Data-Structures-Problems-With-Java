package dsquestions.trees;

public class CountGoodNodesInBT {
    public int goodNodes(TreeNode root) {
        return getGoodNodesCount(root, Integer.MIN_VALUE);
    }

    private static int getGoodNodesCount(TreeNode root, int maxValue) {
        if (root == null) {
            return 0;
        }

        int val = root.val;
        int goodNodesCount = 0;

        if (val >= maxValue) {
            goodNodesCount++;
        }

        maxValue = Math.max(maxValue, val);

        goodNodesCount += getGoodNodesCount(root.left, maxValue);
        goodNodesCount += getGoodNodesCount(root.right, maxValue);

        return goodNodesCount;
    }

}
