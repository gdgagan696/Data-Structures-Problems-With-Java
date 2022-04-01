package dsquestions.strings;

public class ReverseString {
    public static String reverseString(char[] s) {
        int i = 0, j = s.length-1;
        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
        return new String(s);

    }


    public static void main(String[] args) {
        System.out.println(reverseString(new char[]{'h','e','l','l','o'}));

    }
}
