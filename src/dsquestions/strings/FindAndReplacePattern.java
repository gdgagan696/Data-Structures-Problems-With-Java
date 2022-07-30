package dsquestions.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        if (words == null || pattern == null) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (isIsomorphic(word, pattern)) {
                result.add(word);
            }
        }
        return result;

    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hm.containsKey(s.charAt(i))) {
                if (hm.containsValue(t.charAt(i))) return false;
                hm.put(s.charAt(i), t.charAt(i));
            } else if (hm.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        System.out.println(findAndReplacePattern(words, "abb"));
    }
}
