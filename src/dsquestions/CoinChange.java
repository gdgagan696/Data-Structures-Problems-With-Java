package dsquestions;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	public static int coinChangeUtil(int[] coins,int amount,Map<String, Integer>hm) {
		if (amount == 0) {
			return 0;
		}
		if (amount < 0) {
			return -1;
		}
		if(hm.containsKey("CoinChange-"+amount)) {
			return hm.get("CoinChange-"+amount);
		}
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int temp = coinChangeUtil(coins,amount - coin,hm);
			if (temp >=0 && temp < min) {
				min = 1 + temp;
			}

		}
		hm.put("CoinChange-"+amount,min==Integer.MAX_VALUE?-1:min);
		return min==Integer.MAX_VALUE?-1:min;

	}

	public static int coinChange(int[] coins, int amount) {
		Map<String, Integer>hm=new HashMap<>();
		return coinChangeUtil(coins,amount,hm);

	}

	public static void main(String[] args) {
		System.err.println(coinChange(new int[] { 1}, 2));

	}

}
