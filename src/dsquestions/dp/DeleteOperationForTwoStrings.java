package dsquestions.dp;

public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int lcs = longestCommonSubsequence(word1, word2, word1.length(), word2.length(), dp);
        return word1.length() + word2.length() - 2 * lcs;

    }

    public static int longestCommonSubsequence(String text1, String text2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            int ans = 1 + longestCommonSubsequence(text1, text2, m - 1, n - 1, dp);
            dp[m][n] = ans;
        } else {
            int ans = Math.max(longestCommonSubsequence(text1, text2, m - 1, n, dp),
                    longestCommonSubsequence(text1, text2, m, n - 1, dp));
            dp[m][n] = ans;
        }
        return dp[m][n];
    }

}
