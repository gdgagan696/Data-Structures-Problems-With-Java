package dsquestions.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class RelativeSort {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> hm = new HashMap<>();
        Set<Integer> set = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        List<Integer> remaining = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int x : arr1) {
            if (!set.contains(x)) {
                remaining.add(x);
            }
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        for (int x : arr2) {
            for (int i = 0; i < hm.get(x); i++) {
                result.add(x);
            }
        }
        Collections.sort(remaining);
        result.addAll(remaining);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(relativeSortArray(arr1, arr2));
    }
}
