package dsquestions.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{i,hm.get(target-nums[i])};
            }
            hm.put( nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2,7,11,15},9));
    }
}
