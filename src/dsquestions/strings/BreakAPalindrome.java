package dsquestions.strings;

public class BreakAPalindrome {
    public static String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char palindromeArray[] = palindrome.toCharArray();
        for (int i = 0; i < palindromeArray.length; i++) {
            if (palindromeArray[i] != 'a') {
                char old = palindromeArray[i];
                palindromeArray[i] = 'a';
                if (!isPalindrome(new String(palindromeArray))) {
                    return new String(palindromeArray);
                }
                palindromeArray[i] = old;
            }
        }
        palindromeArray[palindromeArray.length - 1] = 'b';
        return new String(palindromeArray);
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j && str.charAt(i) == str.charAt(j)) {
            i++;
            j--;
        }
        return i == j;
    }

    public static void main(String[] args) {
        System.out.println(breakPalindrome("aba"));
    }
}
