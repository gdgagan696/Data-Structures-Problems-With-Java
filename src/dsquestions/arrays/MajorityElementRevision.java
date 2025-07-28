package dsquestions.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElementRevision {

    public int majorityElement(int[] nums) {

        Map<Integer,Integer>hm=new HashMap<>();
        for (int x:nums){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        for(int x:hm.keySet()){
            if(hm.get(x)>nums.length/2){
                return x;
            }
        }
        return -1;

    }

}
