package dsquestions.backtracking;

import java.util.HashMap;
import java.util.Map;

public class MaxScoreWords {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : letters) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        return maxScoreWordsUtil(words, frequencyMap, score, 0);

    }

    private int maxScoreWordsUtil(String[] words, Map<Character, Integer> frequencyMap, int[] score, int i) {
        if (i >= words.length) {
            return 0;
        }
        int op1 = maxScoreWordsUtil(words, frequencyMap, score, i + 1);
        boolean canForm = true;
        Map<Character, Integer> tempMap = new HashMap<>();
        for (char ch : words[i].toCharArray()) {
            tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : tempMap.keySet()) {
            if (!frequencyMap.containsKey(ch) || tempMap.get(ch) > frequencyMap.get(ch)) {
                canForm = false;
            }
        }
        if (canForm) {
            for (char ch : words[i].toCharArray()) {
                tempMap.put(ch, tempMap.getOrDefault(ch, 0) - 1);
            }
            int temp = 0;
            for (char ch : words[i].toCharArray()) {
                temp += score[ch - 'a'];
            }
            op1 = Math.max(op1, temp + maxScoreWordsUtil(words, tempMap, score, i + 1));
            for (char ch : words[i].toCharArray()) {
                tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
            }
        }
        return op1;
    }

}
