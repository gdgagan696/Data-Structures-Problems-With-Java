package dsquestions.strings;

import java.util.HashSet;
import java.util.Set;

public class HasAllCodes {

    public static boolean hasAllCodes(String s, int k) {

        if (k == 0) {
            return true;
        }
        Set<String> hs = new HashSet<>();
        for (int i = 0; i + k <= s.length(); i++) {
            hs.add(s.substring(i, i + k));
        }
        return hs.size() == 1 << k;
    }


    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110110", 2));
    }

}
