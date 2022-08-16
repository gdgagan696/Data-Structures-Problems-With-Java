package dsquestions.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> hm = new LinkedHashMap<>();
        Integer arr[] = new Integer[26];
        int arr1[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            if (arr[ch - 'a'] == null) {
                arr[ch - 'a'] = i;
            }
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 1) {
                return arr[entry.getKey() - 'a'];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
