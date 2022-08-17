package dsquestions.strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {

        Set<String> set = new HashSet<>();
        String[] mappings = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        for (String word : words) {
            StringBuilder mappedWord = new StringBuilder();
            for (char ch : word.toCharArray()) {
                mappedWord.append(mappings[ch - 'a']);
            }
            set.add(mappedWord.toString());
        }
        return set.size();

    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
