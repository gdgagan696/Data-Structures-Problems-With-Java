package dsquestions.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagram {

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> hm = new HashMap<>();
        int i = 0, j = 0;
        int count;
        List<Integer> result = new ArrayList<>();
        for (char ch : p.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        count = hm.size();
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) - 1);
                if (hm.get(ch) == 0) {
                    count--;
                }
            }
            if (j - i + 1 == p.length()) {
                if (count == 0) {
                    result.add(i);
                }
                char chi = s.charAt(i);
                if (hm.containsKey(chi)) {
                    hm.put(chi, hm.get(chi) + 1);
                    if (hm.get(chi) == 1){
                        count++;
                    }
                }
                i++;

            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
