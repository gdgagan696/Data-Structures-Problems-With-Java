package dsquestions;

import java.util.HashMap;

public class Stock_Profit {

	private static int maxProfit(int[] prices) {
		HashMap<String, Integer> hm = new HashMap<>();
		return maxProfitHelper(prices, 0, 0, 1, hm);
	}

	private static int maxProfitHelper(int[] prices, int i, int buyOrSell, int threshold, HashMap<String, Integer> hm) {
		if (i >= prices.length || threshold == 0) {
			return 0;
		}
		String key = i + "sellOrBuy" + buyOrSell;
		if (hm.containsKey(key)) {
			return hm.get(key);
		}
		int x = 0;
		if (buyOrSell == 0) {
			int buy = maxProfitHelper(prices, i + 1, 1, threshold, hm) - prices[i];
			int noBuy = maxProfitHelper(prices, i + 1, 0, threshold, hm);
			x = Math.max(buy, noBuy);
		} else {
			int sell = maxProfitHelper(prices, i + 1, 0, threshold - 1, hm) + prices[i];
			int noSell = maxProfitHelper(prices, i + 1, 1, threshold, hm);
			x = Math.max(sell, noSell);
		}
		hm.put(key, x);
		return x;
	}

	public static void main(String[] args) {

		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

}
