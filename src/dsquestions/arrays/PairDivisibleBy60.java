package dsquestions.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairDivisibleBy60 {
    public static int numPairsDivisibleBy60(int[] time) {

        Map<Integer,Integer> hm=new HashMap<>();
        int result=0;
        for(int x:time){
            int num=x%60;
            if(num==0){
                result+=hm.getOrDefault(num,0);
            }
            else {
                result+=hm.getOrDefault(60-num,0);
            }
           hm.put(num,hm.getOrDefault(num,0)+1);
        }
        return result;
    }

    public static void main(String[]args){
        System.out.println(numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }
}
