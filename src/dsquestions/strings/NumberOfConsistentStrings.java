package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class NumberOfConsistentStrings {

    public static int countConsistentStrings(String allowed, String[] words) {

        Map<Character, Integer> hm = new HashMap<>();
        int res = 0;
        for (char ch : allowed.toCharArray()) {
            hm.put(ch, 1);
        }
        for (String word : words) {
            boolean exists = true;
            for (char ch : word.toCharArray()) {
                if (!hm.containsKey(ch)) {
                    exists = false;
                }
            }
            if (exists) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println(countConsistentStrings(allowed, words));

    }

}
