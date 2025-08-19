package dsquestions.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayToTwoDArray {

    public List<List<Integer>> findMatrix(int[] nums) {

        Map<Integer, Integer> hm = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int max = -1;
        for (int x : nums) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
            max = Math.max(max, hm.get(x));
        }
        for (int i = 0; i < max; i++) {
            result.add(new ArrayList<>());
        }
        for (int key : hm.keySet()) {
            for (int i = 0; i < hm.get(key); i++) {
                result.get(i).add(key);
            }
        }
        return result;


    }

}
