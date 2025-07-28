package dsquestions.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BannedWords {

    public static String mostCommonWord(String paragraph, String[] banned) {
        String sanitisedPara = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        Set<String> bannerWords = Arrays.stream(banned).collect(Collectors.toSet());
        Map<String, Integer> hm = new HashMap<>();
        int max = -1;
        String res = "";

        for (String s : sanitisedPara.split("\\s+")) {
            if (!bannerWords.contains(s)) {
                hm.put(s, hm.getOrDefault(s, 0) + 1);
                if (hm.get(s) > max) {
                    max = hm.get(s);
                    res = s;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        System.out.println(mostCommonWord(paragraph,banned));
    }

}
