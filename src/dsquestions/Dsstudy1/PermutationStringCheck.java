package dsquestions.Dsstudy1;

import java.util.HashMap;
import java.util.Map;

public class PermutationStringCheck {
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int i = 0, j = 0, n = s2.length();
        int k = s1.length();
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        int m = hm.size();
        while (j < n) {
            char ch = s2.charAt(j);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) - 1);
                if (hm.get(ch) == 0) {
                    m--;
                }
            }
            if (j - i + 1 == k) {
                if (m == 0) {
                    return true;
                }
                char chith = s2.charAt(i);
                if (hm.containsKey(chith)) {
                    hm.put(chith, hm.get(chith) + 1);
                    if (hm.get(chith)==1) {
                        m++;
                    }
                }
                i++;
            }
            j++;

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine"));


    }
}
