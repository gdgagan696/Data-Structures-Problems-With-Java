package dsquestions.maths;

import java.util.HashMap;
import java.util.Map;

public class GoodPairs {

    public static int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int x:nums){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        int count=0;
        for(int x:hm.keySet()){
            int n=hm.get(x);
            count+=n*(n-1)/2;
        }
        return count;
    }

    public static void main(String[]args){
        System.out.println(numIdenticalPairs(new int[]{1,2,1,1,2,3}));
    }
}
