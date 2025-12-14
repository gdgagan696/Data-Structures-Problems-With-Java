package dsquestions.strings;

import java.util.Set;

public class VowelGame {

    public static boolean doesAliceWin(String s) {

        int total = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                total++;
            }
        }
        if (total == 0) {
            return false;
        }
        return true;


    }

    public static void main(String[] args) {

        System.out.println(doesAliceWin("leetcoder"));
        System.out.println(doesAliceWin("bbcd"));
        System.out.println(doesAliceWin("leetcoder"));

    }

}
