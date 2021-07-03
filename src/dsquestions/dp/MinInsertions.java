package dsquestions.dp;

public class MinInsertions {

    public  static int minInsertions(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int lcs = longestCommonSubsequence_TopDown(s, reverse);
        return s.length() - lcs;
    }


    public static int longestCommonSubsequence_TopDown(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    public static void main(String[]args){
        System.out.println(minInsertions("mbadm"));
        System.out.println(minInsertions("leetcode"));
    }
}
