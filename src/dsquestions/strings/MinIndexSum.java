package dsquestions.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinIndexSum {

    public static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> hm = new HashMap<>();
        Set<String> res = new HashSet<>();
        int min = 99999;
        for (int i = 0; i < list1.length; i++) {
            hm.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            String str = list2[i];
            if (hm.containsKey(str)) {
                int sum = i + hm.get(str);
                if (sum < min) {
                    min = sum;
                    res.clear();
                    res.add(str);
                } else if (sum == min) {
                    min = sum;
                    res.add(str);
                }
            }
        }
        return res.toArray(String[]::new);
    }

    public static String[] findRestaurant2(String[] list1, String[] list2) {

        Map<String, Integer> hm = new HashMap<>();
        Map<Integer, Set<String>> res = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hm.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            String str = list2[i];
            if (hm.containsKey(str)) {
                int sum = i + hm.get(str);
                res.putIfAbsent(sum, new HashSet<>());
                res.get(sum).add(str);
            }
        }
        Integer minKey = Collections.min(res.keySet());

        return res.get(minKey).toArray(String[]::new);
    }

    public static void main(String[] args) {

        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"}, list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));

    }

}
