package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        int count = hm.size();
        int k = s1.length();
        int i = 0, j = 0;
        while (j < s2.length()) {
            char ch = s2.charAt(j);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) - 1);
                if (hm.get(ch) == 0) {
                    count--;
                }
            }

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (count == 0) {
                    return true;
                } else {
                    char chi = s2.charAt(i);
                    if (hm.containsKey(chi)) {
                        hm.put(chi, hm.get(chi) + 1);
                        if (hm.get(chi) == 1) {
                            count++;
                        }
                    }
                    i++;
                    j++;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
