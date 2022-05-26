package dsquestions.dp;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {

        Integer[] dp = new Integer[amount + 1];
        return coinChangeUtil(coins, amount, dp);
    }

    private static int coinChangeUtil(int[] coins, int amount, Integer[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != null) return dp[amount];
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int temp = coinChangeUtil(coins, amount - coin, dp);
                if (temp >= 0 && temp < ans) {
                    ans = temp + 1;
                }
            }
        }

        return dp[amount] = ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 11));
    }
}
