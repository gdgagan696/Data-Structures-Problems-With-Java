package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class SingleElement {

    public static int singleNonDuplicate(int[] nums) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int x:nums){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:hm.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[]args){
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }
}
