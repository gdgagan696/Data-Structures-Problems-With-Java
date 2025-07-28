package dsquestions.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer>res=new HashSet<>();
        for (int x:nums1){
            if(set.contains(x)){
                res.add(x);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();

    }
    public int[] intersectionV2(int[] nums1, int[] nums2) {
        Set<Integer> set1=Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2=Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        return set1.stream().mapToInt(x -> x).toArray();

    }
}
