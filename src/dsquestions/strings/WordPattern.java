package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {

        String[] splittedString = s.split(" ");
        if (pattern.length() != splittedString.length) return false;
        Map<Character, String> charToStringMap = new HashMap<>();
        Map<String, Character> stringToCharMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (charToStringMap.containsKey(ch) && !charToStringMap.get(ch).equals(splittedString[i])) {
                return false;
            } else if (stringToCharMap.containsKey(splittedString[i]) && !stringToCharMap.get(splittedString[i]).equals(ch)) {
                return false;
            } else {
                charToStringMap.put(ch, splittedString[i]);
                stringToCharMap.put(splittedString[i], ch);
            }
        }
        return true;

    }
}
