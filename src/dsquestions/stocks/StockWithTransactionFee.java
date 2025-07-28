package dsquestions.stocks;

public class StockWithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {
        int buy=-prices[0];
        int sale=0;
        for(int i=1;i<prices.length;i++){
            int tempBuy=Math.max(buy,sale-prices[i]);
            sale=Math.max(sale,buy+prices[i]-fee);
            buy=tempBuy;
        }
        return sale;
    }
    public static void main(String[]args){
        System.out.println(maxProfit(new int[]{1,3,2,8,4,9},2));
    }
}
