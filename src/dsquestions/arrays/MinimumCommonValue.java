package dsquestions.arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set= IntStream.of(nums2).boxed().collect(Collectors.toSet());
        for (int x:nums1){
            if(set.contains(x)){
                return x;
            }
        }
        return -1;
    }
}
