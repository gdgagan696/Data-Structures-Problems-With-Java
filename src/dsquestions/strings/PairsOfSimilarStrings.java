package dsquestions.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairsOfSimilarStrings {

    public static int similarPairs(String[] words) {

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            Set<Character> set1 = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                set1.add(c);
            }
            for (int j = i + 1; j < words.length; j++) {
                Set<Character> set2 = new HashSet<>();
                for (char c : words[j].toCharArray()) {
                    set2.add(c);
                }
                if (set1.equals(set2)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String[] words = {"aba", "aabb", "abcd", "bac", "aabc"};
        System.out.println(similarPairs(words));
    }


}
