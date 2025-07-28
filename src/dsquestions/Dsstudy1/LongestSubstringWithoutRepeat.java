package dsquestions.Dsstudy1;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int n = s.length();
        int max = 0;

        Map<Character, Integer> hm = new HashMap<>();

        while (j < n) {
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
                int window = j - i + 1;
                max = Math.max(window, max);
            }
            j++;

        }
        return max;
    }
}
