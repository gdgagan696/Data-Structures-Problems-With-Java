package dsquestions.stocks.revision;

import java.util.HashMap;
import java.util.Map;

public class StocksII {
    public static int maxProfit(int[] prices) {
        Map<String, Integer> hm = new HashMap<>();
        return maxProfit(prices, 0, true, hm);
    }

    private static int maxProfit(int[] prices, int i, boolean buy, Map<String, Integer> hm) {
        if (i >= prices.length) {
            return 0;
        }
        String key = i + "" + buy;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        int profit = Integer.MIN_VALUE;
        if (buy) {
            int op1 = maxProfit(prices, i + 1, false, hm) - prices[i];
            int op2 = maxProfit(prices, i + 1, true, hm);
            profit = Math.max(profit, Math.max(op1, op2));
        } else {
            int op1 = maxProfit(prices, i + 1, true, hm) + prices[i];
            int op2 = maxProfit(prices, i + 1, false, hm);
            profit = Math.max(profit, Math.max(op1, op2));
        }
        hm.put(key, profit);
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
