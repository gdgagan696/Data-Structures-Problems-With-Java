package dsquestions.strings;

import java.util.HashMap;

public class MaxPower {

    public static int maxPower(String s) {
        int i = 0, j = 0, ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (j < s.length()) {
            char ch = s.charAt(j);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            if (hm.size() == 1) {
                ans = Math.max(j - i + 1, ans);
            } else if (hm.size() > 1) {

                while (hm.size() > 1) {
                    char temp = s.charAt(i);
                    hm.put(temp, hm.get(temp) - 1);
                    if (hm.get(temp) == 0) {
                        hm.remove(temp);
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("hooraaaaaaaaaaay"));
        System.out.println(maxPower("triplepillooooow"));

    }
}
