package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FrequentVowelAndConsonant {

    public static int maxFreqSum(String s) {

        Map<Character, Integer> hm1 = new HashMap<>();
        Map<Character, Integer> hm2 = new HashMap<>();
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int max1 = 0;
        int max2 = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
                max1 = Math.max(max1, hm1.get(ch));
            } else {
                hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
                max2 = Math.max(max2, hm2.get(ch));
            }
        }

        return max1 + max2;
    }


}
