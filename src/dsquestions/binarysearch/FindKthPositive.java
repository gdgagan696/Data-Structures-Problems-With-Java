package dsquestions.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> missing = new ArrayList<>();
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        int miss = 1;
        for (; miss <= 1000; miss++) {
            if (set.contains(miss)) {
                continue;
            }
            k--;
            if (k == 0) {
                return miss;
            }
        }
        for (int i = 0; i < k; i++) {
            miss++;
        }
        return miss;
    }

    public int findKthPositive2(int[] arr, int k) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] - (mid + 1) < k) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i + k;
    }

}
