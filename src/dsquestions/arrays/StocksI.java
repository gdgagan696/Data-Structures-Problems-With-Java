package dsquestions.arrays;

public class StocksI {
    public static int maxProfit(int[] prices) {
        int buyIndex = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[buyIndex]) {
                buyIndex = i;
            }
            maxProfit = Math.max(prices[i] - prices[buyIndex], maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
