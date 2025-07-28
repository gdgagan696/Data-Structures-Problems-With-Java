package dsquestions.practice;

import java.util.HashMap;
import java.util.Map;

public class StocksII {
    public static int maxProfit(int[] prices) {
        Map<String, Integer> hm = new HashMap<>();
        return maxProfitUtil(prices, 0, true, hm);
    }

    private static int maxProfitUtil(int[] prices, int index, boolean buy, Map<String, Integer> hm) {
        if (index >= prices.length) {
            return 0;
        }
        String key = index + "-" + buy;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        int profit = 0;
        if (buy) {
            int op1 = maxProfitUtil(prices, index + 1, false, hm) - prices[index];
            int op2 = maxProfitUtil(prices, index + 1, true, hm);
            profit = Math.max(op1, op2);
        } else {
            int op1 = maxProfitUtil(prices, index + 1, true, hm) + prices[index];
            int op2 = maxProfitUtil(prices, index + 1, false, hm);
            profit = Math.max(op1, op2);
        }
        hm.put(key, profit);
        return profit;
    }


    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }
}
