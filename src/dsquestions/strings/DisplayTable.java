package dsquestions.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DisplayTable {

    public static List<List<String>> displayTable(List<List<String>> orders) {

        Set<String> foodSet = new TreeSet<>();
        Map<Integer, Map<String, Integer>> hm = new TreeMap<>();
        for (List<String> order : orders) {
            int tableNum = Integer.parseInt(order.get(1));
            String food = order.get(2);
            hm.putIfAbsent(tableNum, new HashMap<>());
            Map<String, Integer> tableFoodCount = hm.get(tableNum);
            tableFoodCount.put(food, tableFoodCount.getOrDefault(food, 0) + 1);
            foodSet.add(order.get(2));
        }
        List<List<String>> result = new ArrayList<>();
        List<String> foodList = new ArrayList<>();
        foodList.add("Table");
        foodList.addAll(foodSet);
        result.add(foodList);
        for (int tableNum : hm.keySet()) {
            List<String> tableFoodCount = new ArrayList<>();
            tableFoodCount.add(tableNum + "");
            for (String food : foodSet) {
                Map<String, Integer> tableFoodCountMap = hm.get(tableNum);
                tableFoodCount.add(tableFoodCountMap.getOrDefault(food, 0) + "");
            }
            result.add(tableFoodCount);
        }
        return result;
    }

    public static void main(String[] args) {

        List<List<String>> orders = new ArrayList<>();

        orders.add(Arrays.asList("David", "3", "Ceviche"));
        orders.add(Arrays.asList("Corina", "10", "Beef Burrito"));
        orders.add(Arrays.asList("David", "3", "Fried Chicken"));
        orders.add(Arrays.asList("Carla", "5", "Water"));
        orders.add(Arrays.asList("Carla", "5", "Ceviche"));
        orders.add(Arrays.asList("Rous", "3", "Ceviche"));
        System.out.println(displayTable(orders));


    }

}
