package dsquestions.strings;

public class LCS {

    public static int longestCommonSubsequence(String text1, String text2) {
        Integer dp[][] = new Integer[text1.length() + 1][text2.length() + 1];
        return longestCommonSubsequenceUtil(text1, 0, text2, 0, dp);
    }

    private static int longestCommonSubsequenceUtil(String text1, int i, String text2, int j, Integer[][] dp) {
        if (i >= text1.length()) {
            return 0;
        }
        if (j >= text2.length()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int op1 = 0;
        int op2 = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            op1 = 1 + longestCommonSubsequenceUtil(text1, i + 1, text2, j + 1, dp);
        } else {
            op2 = Math.max(longestCommonSubsequenceUtil(text1, i + 1, text2, j, dp),
                    longestCommonSubsequenceUtil(text1, i, text2, j + 1, dp));
        }
        return dp[i][j] = Math.max(op1, op2);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
