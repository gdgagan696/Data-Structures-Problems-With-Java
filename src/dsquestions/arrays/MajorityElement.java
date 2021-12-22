package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    private static int majorityElement(int[] nums) {
        Map<Integer,Integer>hm=new HashMap<>();
        for(int x:nums){
            hm.put(x, hm.getOrDefault(x,0)+1);
        }
        int maj=nums.length/2;
        for(int x: hm.keySet()){
            if(hm.get(x)>maj){
                return x;
            }
        }
        return -1;

    }
    public static void main(String[]args){
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));


    }
}
