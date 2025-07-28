package dsquestions.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortArrayByFrequency {
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> hm = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        List<Integer> keys=new ArrayList<>(hm.keySet());
        keys.sort((a,b)->{
            if(Objects.equals(hm.get(a), hm.get(b))){
                return Integer.compare(b,a);
            }
            return Integer.compare(hm.get(a),hm.get(b));
        });
        int []res=new int[nums.length];
        int k=0;
        for(int key:keys){
            for (int i=0;i<hm.get(key);i++){
                res[k++]=key;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{1,1,2,2,2,3})));
    }
}
