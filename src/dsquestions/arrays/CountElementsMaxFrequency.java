package dsquestions.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountElementsMaxFrequency {
    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencyMap = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> 1)));
        int max=frequencyMap.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).get();
        return frequencyMap.entrySet().stream().filter(s->s.getValue()==max)
                .map(Map.Entry::getValue)
                .reduce(0,(a,b)->a+b);


    }

    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1,2,2,3,1,4}));
    }
}
