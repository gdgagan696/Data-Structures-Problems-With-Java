package dsquestions.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntersectionOfArray {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Long> hm=Arrays.stream(nums1).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<Integer>result=new ArrayList<>();
        for (int x:nums2){
            if(hm.containsKey(x)){
                hm.put(x,hm.get(x)-1);
                if(hm.get(x)==0){
                    hm.remove(x);
                }
                result.add(x);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
