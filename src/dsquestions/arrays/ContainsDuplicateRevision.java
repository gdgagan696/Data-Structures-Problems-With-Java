package dsquestions.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContainsDuplicateRevision {
    public boolean containsDuplicate(int[] nums) {


        Map<Integer,Long> hm=Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for (int x:hm.keySet()){
            if(hm.get(x)>=2){
                return true;
            }
        }
        return false;

    }

}
