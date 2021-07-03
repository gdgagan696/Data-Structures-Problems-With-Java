package dsquestions.stocks;

public class StockWithCoolDown {
    public static int maxProfit(int[] prices) {
        int buy=-prices[0];
        int sale=0;
        int coolDown=0;
        for(int i=1;i<prices.length;i++){
            int tempBuy=Math.max(buy,coolDown-prices[i]);
            int tempSale=Math.max(sale,prices[i]+buy);
            coolDown=Math.max(sale,coolDown);
            buy=tempBuy;
            sale=tempSale;
        }
        return sale;
    }

    public static void main(String[]args){
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }
}
