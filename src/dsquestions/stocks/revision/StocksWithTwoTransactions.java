package dsquestions.stocks.revision;

import java.util.HashMap;
import java.util.Map;

public class StocksWithTwoTransactions {
    public static int maxProfit(int[] prices) {
        Map<String, Integer> hm = new HashMap<>();
        return maxProfit(prices, 0, true, 2, hm);
    }

    private static int maxProfit(int[] prices, int i, boolean buy, int transactions, Map<String, Integer> hm) {
        if (i >= prices.length || transactions <= 0) {
            return 0;
        }
        String key = i + "" + buy + "" + transactions;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        int profit = Integer.MIN_VALUE;
        if (buy) {
            int op1 = maxProfit(prices, i + 1, false, transactions, hm) - prices[i];
            int op2 = maxProfit(prices, i + 1, true, transactions, hm);
            profit = Math.max(profit, Math.max(op1, op2));
        } else {
            int op1 = maxProfit(prices, i + 1, true, transactions - 1, hm) + prices[i];
            int op2 = maxProfit(prices, i + 1, false, transactions, hm);
            profit = Math.max(profit, Math.max(op1, op2));
        }
        hm.put(key, profit);
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
