package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {

    public static int numRabbits(int[] answers) {

        int count = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int x : answers) {
            if (!hm.containsKey(x)) {
                count++;
                if (x > 0) {
                    hm.put(x, x);
                }
            } else {
                count++;

                hm.put(x, hm.get(x) - 1);
                if (hm.get(x) == 0) {
                    hm.remove(x);
                }
            }
        }
        return count + hm.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {

        System.out.println(numRabbits(new int[]{1, 0, 1, 0, 0}));
    }

}
