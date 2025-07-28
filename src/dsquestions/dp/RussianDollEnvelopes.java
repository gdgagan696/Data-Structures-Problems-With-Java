package dsquestions.dp;

import java.util.Arrays;

public class RussianDollEnvelopes {

    public static int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        int dp[][] = new int[envelopes.length][envelopes.length];
        return maxEnvelopesUtil(envelopes, -1, 0, dp);
    }

    private static int maxEnvelopesUtil(int[][] envelopes, int prev, int index, int[][] dp) {

        if (index == envelopes.length) {
            return 0;
        }
        if (prev != -1 && dp[prev][index] != 0) {
            return dp[prev][index];
        }
        int op1 = 0;
        if (prev == -1 || (envelopes[prev][0] < envelopes[index][0] && envelopes[prev][1] < envelopes[index][1])) {
            op1 = 1 + maxEnvelopesUtil(envelopes, index, index + 1, dp);
        }
        int op2 = maxEnvelopesUtil(envelopes, prev, index + 1, dp);
        if (prev != -1) {
            dp[prev][index] = Math.max(op1, op2);
        }
        return Math.max(op1, op2);
    }


    public static void main(String[] args) {
        int[][] envelops = {
                {5, 4}, {6, 4}, {6, 7}, {2, 3}
        };
        System.out.println(maxEnvelopes(envelops));

    }

}
