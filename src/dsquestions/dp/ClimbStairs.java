package dsquestions.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    static Map<Integer, Integer> hm = new HashMap<>();

    public static int climbStairs(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (hm.containsKey(n)) return hm.get(n);
        int n1 = climbStairs(n - 1);
        int n2 = climbStairs(n - 2);
        hm.put(n, n1 + n2);
        return n1 + n2;
    }

    public static int climbStairs2(int n) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return climbStairs2Util(0, n, dp);
    }

    private static int climbStairs2Util(int i, int n, int[] dp) {
        if (i == n) return 1;
        if (i > n) return 0;
        if (dp[i] != -1) return dp[i];
        int numWays = climbStairs2Util(i + 1, n, dp) + climbStairs2Util(i + 2, n, dp);
        dp[i] = numWays;
        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs2(3));
    }
}
