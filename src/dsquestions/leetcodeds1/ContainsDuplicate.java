package dsquestions.leetcodeds1;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        if(nums==null|| nums.length==0)return false;
        Map<Integer,Integer> hm=new HashMap<>();
        for(int x:nums){
            hm.put(x,hm.getOrDefault(x,0)+1);
            if(hm.get(x)>=2)return true;
        }
        return false;
    }

    public static void main(String[]args){
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
    }
}
