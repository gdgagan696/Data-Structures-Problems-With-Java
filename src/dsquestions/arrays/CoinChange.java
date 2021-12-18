package dsquestions.arrays;

import java.util.HashMap;

public class CoinChange {
    public static int change(int amount, int[] coins) {
        HashMap<String,Integer>hm=new HashMap<>();
        return changeCoins(amount,coins,0,hm);

    }

    public static int changeCoins(int amount,int []coins,int i,HashMap<String,Integer>hm){

        if(amount==0){
            return 1;
        }
        if(amount<0 || i>=coins.length){
            return 0;
        }
        if(hm.containsKey(amount+"-"+(coins.length-i))){
            return hm.get(amount+"-"+(coins.length-i));
        }
        int op1=changeCoins(amount,coins,i+1,hm);
        int op2=changeCoins(amount-coins[i],coins,i,hm);
        hm.put(amount+"-"+(coins.length-i),op1+op2);
        return op1+op2;
    }

    public static void main(String []args){
        System.out.println(change(5,new int[]{1,2,5}));
    }

}
