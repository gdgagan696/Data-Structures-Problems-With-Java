package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeastNumbersOfUniqueIntegers {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Long> frequencyMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        i -> i,
                        Collectors.counting()
                ));
        List<Map.Entry<Integer, Long>> elements = new ArrayList<>(frequencyMap.entrySet());

        elements.sort((a, b) -> Math.toIntExact(a.getValue() - b.getValue()));

        for (Map.Entry<Integer, Long> entry : elements) {
            if (entry.getValue() <= k) {
                k -= entry.getValue();
                frequencyMap.remove(entry.getKey());
            } else {
                break;
            }
        }
        return frequencyMap.size();
    }

    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }
}
