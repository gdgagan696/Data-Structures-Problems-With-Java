package dsquestions.arrays;

public class MinimumLengthString {
    public static int minimumLength(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
            }
            while (j > 0 && s.charAt(j) == s.charAt(j - 1)) {
                j--;
            }
            i++;
            j--;
        }
        return j < i ? 0 : j - i + 1;
    }

    public static void main(String[] args) {
        System.out.println(minimumLength("aabccabba"));
    }
}
