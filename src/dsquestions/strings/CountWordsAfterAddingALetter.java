package dsquestions.strings;

import java.util.stream.Collectors;

public class CountWordsAfterAddingALetter {

    public static int wordCount(String[] startWords, String[] targetWords) {

        int count = 0;
        sort(startWords);
        sort(targetWords);
        for (String word : targetWords) {
            for (String start : startWords) {
                if (word.equals(start) || word.length()==start.length() || word.length() - start.length() > 1) {
                    continue;
                }
                int i = 0;
                int diff = 0;
                while (i < start.length()) {
                    if (word.charAt(i) != start.charAt(i)) {
                        diff++;
                    }
                    i++;
                }
                if (diff == 1) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void sort(String[] words) {

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].chars()
                    .sorted()
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining());
        }
    }

    public static void main(String[] args) {

        String[] startWords = {"ant", "act", "tack"};
        String[] targetWords = {"tack", "act", "acti"};
        System.out.println(wordCount(startWords,targetWords));

    }
}
