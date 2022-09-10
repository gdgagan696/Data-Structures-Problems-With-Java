package dsquestions.stocks;

import java.util.HashMap;
import java.util.Map;

public class BuySellStocksWithKTransactions {
    public static int maxProfit(int k, int[] prices) {
        Map<String, Integer> hm = new HashMap<>();
        return maxProfit(0, 0, prices, k, hm);
    }

    private static int maxProfit(int i, int buyOrSell, int[] prices, int k, Map<String, Integer> hm) {
        if (i >= prices.length || k == 0)
            return 0;
        if (hm.containsKey(i + "-" + buyOrSell + "-" + k)) {
            return hm.get(i + "-" + buyOrSell + "-" + k);
        }
        int x = 0;
        if (buyOrSell == 0) {
            int buy = maxProfit(i + 1, 1, prices, k, hm) - prices[i];
            int noBuy = maxProfit(i + 1, 0, prices, k, hm);
            x = Math.max(buy, noBuy);
        } else {
            int sell = maxProfit(i + 1, 0, prices, k - 1, hm) + prices[i];
            int noSell = maxProfit(i + 1, 1, prices, k, hm);
            x = Math.max(sell, noSell);
        }
        hm.put(i + "-" + buyOrSell + "-" + k, x);

        return x;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2, 4, 1};
        System.out.println(maxProfit(k, prices));
    }
}
