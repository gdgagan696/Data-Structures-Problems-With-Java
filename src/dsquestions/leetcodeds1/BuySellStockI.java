package dsquestions.leetcodeds1;

public class BuySellStockI {
    public static int maxProfit(int[] prices) {
        int buy = 0;
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[buy] > prices[i]) {
                buy = i;
            }
            profit = Math.max(profit, prices[i] - prices[buy]);
        }
        return profit;

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));

    }
}
