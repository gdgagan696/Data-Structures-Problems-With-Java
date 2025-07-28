package dsquestions.dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeNumWays {
    public static int coinChange(int[] coins, int amount) {
        Map<String, Integer> hm = new HashMap<>();
        return coinChangeUtil(coins, amount, hm);
    }

    public static int coinChangeUtil(int[] coins, int amount, Map<String, Integer> hm) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (hm.containsKey("CoinChange-" + amount)) {
            return hm.get("CoinChange-" + amount);
        }
        int res=0;
        for (int coin : coins) {
            res+= coinChangeUtil(coins, amount - coin, hm);
        }
        hm.put("CoinChange-" + amount,res);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }
}