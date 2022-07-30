package dsquestions.strings;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        int[] count = new int[26];
        for (String word : words2) {
            int[] tempCounter = getCountArray(word);
            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], tempCounter[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] tempCounter = getCountArray(word);
            boolean isSuperSet = true;
            for (int i = 0; i < 26; i++)
                if (tempCounter[i] < count[i]) {
                    isSuperSet = false;
                    break;
                }
            if (isSuperSet) {
                result.add(word);
            }
        }
        return result;

    }

    private static int[] getCountArray(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"}, words2 = {"e", "o"};
        System.out.println(wordSubsets(words1, words2));
    }
}
