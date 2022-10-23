package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {

        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> hm = new HashMap<>();
        int noOfCharacters = t.length();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0, min = Integer.MAX_VALUE, start = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (hm.containsKey(ch) && hm.get(ch) > 0) {
                noOfCharacters--;
            }
            hm.put(ch, hm.getOrDefault(ch, 0) - 1);
            j++;
            while (noOfCharacters == 0) {
                if (min > j - i) {
                    min = j - i;
                    start = i;
                }
                char ch2 = s.charAt(i);
                hm.put(ch2, hm.getOrDefault(ch2, 0) + 1);
                if (hm.get(ch2) > 0) {
                    noOfCharacters++;
                }
                i++;
            }

        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
