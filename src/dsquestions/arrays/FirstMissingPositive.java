package dsquestions.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        TreeSet<Integer> set=Arrays.stream(nums).boxed().collect(Collectors.toCollection(TreeSet::new));
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return set.last()+1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }

}
