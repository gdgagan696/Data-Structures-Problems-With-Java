package dsquestions.graphs;

import java.util.HashMap;
import java.util.Map;

public class FindJudge {
    public static int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int[] temp : trust) {
            hm.put(temp[0], hm.getOrDefault(temp[0], 0) - 1);
            hm.put(temp[1], hm.getOrDefault(temp[1], 0) + 1);
        }
        for (int key : hm.keySet()) {
            if (hm.get(key) == n - 1) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = {
                {1, 2}
        };
        System.out.println(findJudge(2, trust));
    }
}
