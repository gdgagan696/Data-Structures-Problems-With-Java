package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindPlayersWithZeroOrOneLosses {
    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> hm = new TreeMap<>();
        List<List<Integer>> result = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (int[] match : matches) {
            hm.put(match[1], hm.getOrDefault(match[1], 0) + 1);
            hm.put(match[0], hm.getOrDefault(match[0], 0));
        }
        hm.forEach((key, value) -> {
            if (value <= 1) {
                result.get(value).add(key);
            }
        });
        return result;
    }

    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(findWinners(matches));
    }
}
