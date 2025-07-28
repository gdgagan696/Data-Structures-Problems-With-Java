package dsquestions.dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        Map<Integer,Integer> hm=new HashMap<>();
        return Math.min(minCostClimbingStairs(cost,0,hm),minCostClimbingStairs(cost,1,hm));

    }

    public static int minCostClimbingStairs(int []cost,int i,Map<Integer,Integer>hm){
        if(i>=cost.length){
            return 0;
        }
        if(hm.containsKey(cost.length-i))return hm.get(cost.length-i);
        int min=cost[i]+Math.min(minCostClimbingStairs(cost, i+1,hm),minCostClimbingStairs(cost, i+2,hm));
        hm.put(cost.length-i,min);
        return min;
    }

    public static void main(String[]args){
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));

    }
}
