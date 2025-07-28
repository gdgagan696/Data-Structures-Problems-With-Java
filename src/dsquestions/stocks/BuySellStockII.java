package dsquestions.stocks;

public class BuySellStockII {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyIndex = 0;
        int sellIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sellIndex = i;
            } else {
                maxProfit += (prices[sellIndex] - prices[buyIndex]);
                sellIndex = buyIndex = i;
            }
        }
        maxProfit += (prices[sellIndex] - prices[buyIndex]);
        return maxProfit;


    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));

    }
}
