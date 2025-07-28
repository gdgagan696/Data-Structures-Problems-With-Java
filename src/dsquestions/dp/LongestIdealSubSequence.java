package dsquestions.dp;

public class LongestIdealSubSequence {
    public static int longestIdealString(String s, int k) {
        Integer[][] dp = new Integer[ s.length()][130];
        return longestIdealString(s, k, 0, '#',dp);
    }

    public static int longestIdealString(String s, int k, int si, char prevChar, Integer[][] dp) {
        if (si >= s.length()) return 0;
        if (dp[si][prevChar] != null) {
            return dp[si][prevChar];
        }
        int take = 0;
        if (Math.abs(prevChar - s.charAt(si)) <= k || prevChar == '#') {
            take = 1 + longestIdealString(s, k, si + 1, s.charAt(si), dp);
        }
        int notTake = longestIdealString(s, k, si + 1, prevChar, dp);
        return dp[si][prevChar] = Math.max(take, notTake);
    }

    public static void main(String[] args) {
        System.out.println(longestIdealString("acfgbd", 2));
    }
}
