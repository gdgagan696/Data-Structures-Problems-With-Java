package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public static String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (char ch : order.toCharArray()) {
            if (hm.containsKey(ch)) {
                result.append(String.valueOf(ch).repeat(hm.get(ch)));
                hm.remove(ch);
            }
        }
        hm.keySet().forEach(ch -> result.append(String.valueOf(ch).repeat(hm.get(ch))));
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
    }
}
