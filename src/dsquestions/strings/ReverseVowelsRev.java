package dsquestions.strings;

import java.util.Set;

public class ReverseVowelsRev {

    public String reverseVowels(String s) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (vowels.contains(arr[i]) && vowels.contains(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else if (!vowels.contains(arr[i])) {
                i++;
            } else if (!vowels.contains(arr[j])) {
                j--;
            }
        }
        return new String(arr);

    }

}
