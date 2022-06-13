package dsquestions.dp;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        Integer dp[][] = new Integer[triangle.size()][triangle.size()];
        return minimumTotalUtil(triangle, 0, 0, dp);

    }

    private int minimumTotalUtil(List<List<Integer>> triangle, int row, int index, Integer[][] dp) {

        if (row >= triangle.size()) {
            return 0;
        }
        if (dp[row][index] != null) {
            return dp[row][index];
        }

        int op1 = triangle.get(row).get(index) + minimumTotalUtil(triangle, row + 1, index, dp);
        int op2 = triangle.get(row).get(index) + minimumTotalUtil(triangle, row + 1, index + 1, dp);
        return dp[row][index] = Math.min(op1, op2);
    }

}
