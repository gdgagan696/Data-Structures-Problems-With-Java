package dsquestions.backtracking;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 1;
                } else if (i == dp.length - 1) {
                    dp[i][j] = dp[i][j + 1];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }

            }

        }
        return dp[0][0];
    }

    public static void main(String[]args){
        System.out.println(uniquePaths(3,7));
    }
}
