package dsquestions.revision;

public class CoinChange {

    private static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int x : coins) {
            int temp = coinChange(coins, amount - x);
            if (temp >= 0 && temp < min) {
                min = 1 + temp;
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));

    }
}
