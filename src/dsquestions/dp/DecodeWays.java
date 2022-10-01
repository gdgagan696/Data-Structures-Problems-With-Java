package dsquestions.dp;

import java.util.Arrays;

public class DecodeWays {
    public static int numDecodings(String s) {
        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return numDecodingsUtil(s, 0, dp);

    }

    private static int numDecodingsUtil(String s, int index, int[] dp) {
        if (index == s.length()) {
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int ans = 0;
        if (getNum(s.charAt(index), '0') > 0) {
            int op1 = numDecodingsUtil(s, index + 1, dp);
            ans += op1;
        }
        if (index + 1 < s.length() && getNum(s.charAt(index), '0') > 0
                && getNum(s.charAt(index), s.charAt(index + 1)) <= 26) {
            int op2 = numDecodingsUtil(s, index + 2, dp);
            ans += op2;
        }
        return dp[index] = ans;
    }

    private static int getNum(char ch1, char ch2) {
        return Integer.parseInt(ch1 + "") * 10 + Integer.parseInt(ch2 + "");
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("27"));
    }
}
