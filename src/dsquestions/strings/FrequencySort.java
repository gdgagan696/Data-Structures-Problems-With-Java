package dsquestions.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FrequencySort {
    public static String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        s.chars().forEach(ch -> {
            hm.put((char) ch, hm.getOrDefault((char) ch, 0) + 1);
        });
        StringBuilder sb = new StringBuilder();
        hm.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> {
                    char ch = entry.getKey();
                    for (int i = 0; i < entry.getValue(); i++) {
                        sb.append(ch + "");
                    }
                });
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
