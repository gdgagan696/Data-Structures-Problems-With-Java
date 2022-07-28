package dsquestions.strings;

import java.util.HashMap;

public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = t.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) - 1);
                if (hm.get(ch) == 0) hm.remove(ch);
            } else {
                return false;
            }
        }
        return hm.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abc","cab"));
    }
}
