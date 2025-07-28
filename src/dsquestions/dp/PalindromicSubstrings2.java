package dsquestions.dp;

public class PalindromicSubstrings2 {
    public static int countSubstrings(String s) {
        return countSubstringsUtil(s, 0, s.charAt(0) + "");
    }

    private static int countSubstringsUtil(String s, int i, String current) {
        if (i >= s.length()-1) {
            return 0;
        }
        String temp = current + s.charAt(i + 1);
        int op1 = 0;
        if (isPalindrome(temp)) {
            op1 = 1 + countSubstringsUtil(current, i + 1, current + s.charAt(i + 1));
        }
        int op2 = countSubstringsUtil(s, i + 1, current);
        return op1+op2;
    }

    private static boolean isPalindrome(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }
}
