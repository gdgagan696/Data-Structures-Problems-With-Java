package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class IsIsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ti = t.charAt(i);
            char si = s.charAt(i);
            if (!hm.containsKey(si)) {
                if (hm.containsValue(ti)) return false;
                hm.put(si, ti);
            } else if (hm.get(si) != ti) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
    }
}
