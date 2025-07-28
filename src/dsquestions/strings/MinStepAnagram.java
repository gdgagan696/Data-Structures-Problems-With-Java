package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class MinStepAnagram {

    private static int minSteps(String s, String t) {
        Map<Character, Integer> hm1 = new HashMap<>();
        Map<Character, Integer> hm2 = new HashMap<>();
        for (char ch : s.toCharArray()) {
            hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
        }
        int ans = 0;
        for (char ch : hm1.keySet()) {
            int k1 = hm1.get(ch);
            int k2 = hm2.getOrDefault(ch, 0);
            if (k2 < k1) {
                ans += k1 - k2;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(minSteps("bab", "aba"));
        System.out.println(minSteps("leetcode", "practice"));
        System.out.println(minSteps("anagram", "mangaar"));
        System.out.println(minSteps("friend", "family"));

    }
}
