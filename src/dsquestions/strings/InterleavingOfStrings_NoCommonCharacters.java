package dsquestions.strings;

public class InterleavingOfStrings_NoCommonCharacters {

    public static boolean isInterleave(String s1, String s2, String s3) {

        int i = 0, j = 0, k = 0;
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        while (k < n3) {
            if (i < n1 && s1.charAt(i) == s3.charAt(k)) {
                i++;
            } else if (j < n2 && s2.charAt(j) == s3.charAt(k)) {
                j++;
            } else {
                return false;
            }
            k++;
        }
        if (i < n1 || j < n2) {
            return false;
        }
        return true;

    }

    public static void main(String[] agrs) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));

    }
}
