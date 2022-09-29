package dsquestions.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return arr[a[1]] - arr[b[1]];
            } else {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int temp[] = new int[]{Math.abs(num - x), i};
            pq.add(temp);
        }
        while (k-- > 0) {
            result.add(arr[pq.poll()[1]]);
        }
        result.sort(Comparator.comparing(Integer::intValue));
        return result;

    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));
    }
}
