package dsquestions.dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningStrings {

    public static List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        partition(s, result, new ArrayList<>());
        return result;

    }

    private static void partition(String s, List<List<String>> result, List<String> tempResult) {

        if(s.length() == 0) {
            result.add(new ArrayList<>(tempResult));
            return;
        }
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(isPalindrome(s, 0, i)) {
                tempResult.add(s.substring(0, i+1));
                partition(s.substring(i+1),result,tempResult);
                tempResult.remove(tempResult.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int i, int j) {

        while (i <= j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i > j;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
