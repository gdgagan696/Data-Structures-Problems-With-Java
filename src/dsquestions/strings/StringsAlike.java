package dsquestions.strings;

import java.util.Set;

public class StringsAlike {
    public static boolean halvesAreAlike(String s) {
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);
        return countVowels(s1) == countVowels(s2);

    }

    private static int countVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (vowels.contains(Character.toLowerCase(ch))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
    }
}
