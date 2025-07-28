package dsquestions.stocks;

public class BuySellStockI {
    private static int maxProfit(int[] prices) {
        int minSoFar = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[minSoFar] > prices[i]) {
                minSoFar = i;
            }
            int temp = prices[i] - prices[minSoFar];
            if (temp > maxProfit) {
                maxProfit = temp;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,2,1}));
    }
}
