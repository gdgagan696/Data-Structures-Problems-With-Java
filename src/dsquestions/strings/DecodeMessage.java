package dsquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class DecodeMessage {

    public static String decodeMessage(String key, String message) {

        Map<Character, Character> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int index = 97;
        for (char ch : key.toCharArray()) {
            if (Character.isAlphabetic(ch) && !hm.containsKey(ch)) {
                hm.put(ch, (char) index);
                index++;
            }
        }
        for (char ch : message.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                sb.append(ch);
            } else {
                sb.append(hm.get(ch));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));

    }

}
