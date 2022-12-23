package dsquestions.stocks;

import java.util.HashMap;

public class StockWithCoolDown {
    public static int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sale = 0;
        int coolDown = 0;
        for (int i = 1; i < prices.length; i++) {
            int tempBuy = Math.max(buy, coolDown - prices[i]);
            int tempSale = Math.max(sale, prices[i] + buy);
            coolDown = Math.max(sale, coolDown);
            buy = tempBuy;
            sale = tempSale;
        }
        return sale;
    }

    private static int maxProfit(int i, int buyOrSell, int[] prices, HashMap<String, Integer> hm) {
        if (i >= prices.length)
            return 0;
        String key = i + "-" + buyOrSell;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        int x = 0;
        if (buyOrSell == 0) {
            int buy = maxProfit(i + 1, 1, prices, hm) - prices[i];
            int noBuy = maxProfit(i + 1, 0, prices, hm);
            x = Math.max(buy, noBuy);
        } else {
            int sell = maxProfit(i + 2, 0, prices, hm) + prices[i];
            int noSell = maxProfit(i + 1, 1, prices, hm);
            x = Math.max(sell, noSell);
        }
        hm.put(key, x);
        return x;
    }

    public static int maxProfit2(int[] prices) {
        HashMap<String, Integer> hm = new HashMap<>();
        return maxProfit(0, 0, prices, hm);

    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
        System.out.println(maxProfit2(new int[]{1, 2, 3, 0, 2}));
    }
}
