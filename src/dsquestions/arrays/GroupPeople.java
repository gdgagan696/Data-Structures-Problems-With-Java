package dsquestions.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeople {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        Map<Integer, List<Integer>> hm = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            hm.putIfAbsent(groupSizes[i], new ArrayList<>());
            hm.get(groupSizes[i]).add(i);
        }
        for (int key : hm.keySet()) {
            List<Integer> temp = new ArrayList<>();
            for (int index : hm.get(key)) {
                if (temp.size() == key) {
                    result.add(temp);
                    temp = new ArrayList<>();
                }
                temp.add(index);
            }
            if (temp.size() > 0) {
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(groupSizes));
    }

}
