package dsquestions.dp;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Map<String, Boolean> dp = new HashMap<>();
        return isInterleaveUtil(s1, 0, s2, 0, s3, 0, dp);

    }

    private static boolean isInterleaveUtil(String s1, int i, String s2, int j, String s3, int k, Map<String, Boolean> dp) {

        if (i >= s1.length() && j >= s2.length()) {
            return true;
        }
        String key = i + "-" + j;
        if (dp.containsKey(key)) return dp.get(key);
        boolean res = false;
        if (i < s1.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k)) {
            res = res || isInterleaveUtil(s1, i + 1, s2, j, s3, k + 1, dp);
        }
        if (j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k)) {
            res = res || isInterleaveUtil(s1, i, s2, j + 1, s3, k + 1, dp);
        }
        dp.put(key, res);
        return res;
    }

    public static void main(String[] args) {

        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }


}
