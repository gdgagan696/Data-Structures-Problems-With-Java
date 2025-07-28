package dsquestions.greedy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaximumOddBinaryNumber {
    public static String maximumOddBinaryNumber(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        String res = "";
        if (hm.containsKey('1')) {
            res = String.join("", Collections.nCopies(hm.get('1') - 1, "1"));
        }
        if (hm.containsKey('0')) {
            res += String.join("", Collections.nCopies(hm.get('0'), "0"));
        }
        res += "1";
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("010"));
        System.out.println(maximumOddBinaryNumber("0101"));
    }
}
