package dsquestions.dp;

public class ShortestCommonSuperSequence {
    public static String shortestCommonSupersequence(String str1, String str2) {
        String lcs = LCS(str1, str2);
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        for (char ch : lcs.toCharArray()) {
            while (ch != str1.charAt(i)) {
                sb.append(str1.charAt(i));
                i++;
            }
            while (ch != str2.charAt(j)) {
                sb.append(str2.charAt(j));
                j++;
            }
            sb.append(ch);
            i++;
            j++;
        }
        return sb.append(str1.substring(i)).append(str2.substring(j)).toString();

    }

    public static String LCS(String str1, String str2) {
        String[][] dp = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = "";
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else if (dp[i - 1][j].length() > dp[i][j - 1].length()) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[str1.length()][str2.length()];

    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
    }
}
