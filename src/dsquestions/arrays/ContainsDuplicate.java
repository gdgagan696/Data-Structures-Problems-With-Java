package dsquestions.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer>temp=hm.getOrDefault(nums[i],new ArrayList<>());
            temp.add(i);
            hm.put(nums[i],temp);
        }
        for(int x:hm.keySet()){
            if(hm.get(x).size()>1){
                List<Integer>indexes=hm.get(x);
                for(int i=0;i<indexes.size()-1;i++){
                    if(Math.abs(indexes.get(i)-indexes.get(i+1))<=k){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[]args){

        System.out.println(containsNearbyDuplicate(new int[]{4,1,2,3,1,5},3));

    }
}
