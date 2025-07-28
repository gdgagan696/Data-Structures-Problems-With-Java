package dsquestions.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

public class WeakestRow {

    public static int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[k];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            hm.put(i, count);
        }
        Map<Integer, Integer> sortedMap =
                hm.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
        int i=0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            if (i>=k) {
                break;
            }
            res[i++] = entry.getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1},
        };
        System.out.println(Arrays.toString(kWeakestRows(mat,3)));
    }
}
