package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

    public static int lengthOfLongestSubstring(String s) {

        int i = 0;
        int j = 0;
        Map<Character, Integer> hm = new HashMap<>();
        int res = 0;
        while (j<s.length()) {
            char ch = s.charAt(j);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            if (hm.get(ch) > 1) {
                while (hm.size() < j - i + 1) {
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                    if (hm.get(s.charAt(i)) == 0) {
                        hm.remove(s.charAt(i));
                    }
                    i++;
                }
            } else {
                res = Math.max(res, j - i + 1);
            }
            j++;

        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

}
