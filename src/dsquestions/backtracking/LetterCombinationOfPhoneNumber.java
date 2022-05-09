package dsquestions.backtracking;

import java.util.*;

public class LetterCombinationOfPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return Collections.emptyList();
        Map<Integer, List<Character>> hm = new HashMap<>();
        hm.put(2, Arrays.asList('a', 'b', 'c'));
        hm.put(3, Arrays.asList('d', 'e', 'f'));
        hm.put(4, Arrays.asList('g', 'h', 'i'));
        hm.put(5, Arrays.asList('j', 'k', 'l'));
        hm.put(6, Arrays.asList('m', 'n', 'o'));
        hm.put(7, Arrays.asList('p', 'q', 'r', 's'));
        hm.put(8, Arrays.asList('t', 'u', 'v'));
        hm.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        List<String> result = new ArrayList<>();
        letterCombinationsUtil(digits, hm, new StringBuilder(), 0, result);
        return result;
    }

    private static void letterCombinationsUtil(String digits, Map<Integer, List<Character>> hm, StringBuilder current, int index, List<String> result) {
        if (index >= digits.length()) {
            result.add(current.toString());
            return;
        }

        for (char ch : hm.get(Integer.parseInt(digits.charAt(index) + ""))) {
            current.append(ch);
            letterCombinationsUtil(digits, hm, current, index + 1, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
