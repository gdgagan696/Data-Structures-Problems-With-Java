package dsquestions.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KthDistinctString {
    public static String kthDistinct(String[] arr, int k) {
        Map<String,Integer>hm=Arrays.stream(arr)
                .collect(Collectors.toMap(
                        Function.identity(),
                        item -> 1,
                        Integer::sum,
                        LinkedHashMap::new
                ));
        List<String>uniques=new ArrayList<>();
        for(String key:hm.keySet()){
            if(hm.get(key)==1) {
                uniques.add(key);
            }
        }

        return uniques.size()<k?"" :uniques.get(k-1);
    }

    public static void main(String[] args) {
        String[]arr={"d","b","c","b","c","a"};
        System.out.println(kthDistinct(arr,2));
    }
}
