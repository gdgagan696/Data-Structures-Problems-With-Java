package dsquestions.practice;

import java.util.Map;

public class StocksI {
    public static int maxProfit(int[] prices) {
        int max=0;
        int min=prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            max= Math.max(max,prices[i]-min);
        }
        return max;
    }

    public static void main(String[] args) {
        int []prices={7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
