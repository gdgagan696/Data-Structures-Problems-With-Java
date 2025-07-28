package dsquestions.arrays;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMappings = new HashMap<>();
        for (String currentStr : strs) {
            char[] currentStrArray = currentStr.toCharArray();
            Arrays.sort(currentStrArray);
            String sortedString = new String(currentStrArray);
            anagramsMappings.compute(sortedString, (key, value) -> {
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(currentStr);
                return value;
            });
        }
        return new ArrayList<>(anagramsMappings.values());
    }


    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
