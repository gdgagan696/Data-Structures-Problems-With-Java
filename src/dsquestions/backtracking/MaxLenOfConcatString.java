package dsquestions.backtracking;

import java.util.Arrays;
import java.util.List;

public class MaxLenOfConcatString {

    public static int maxLength(List<String> arr) {
        return maxLengthUtil(arr, 0, "");
    }

    private static int maxLengthUtil(List<String> arr, int index, String current) {
        if (index >= arr.size()) {
            return isValid(current) ? current.length() : 0;
        }
        int op1 = maxLengthUtil(arr, index + 1, current);
        int op2 = maxLengthUtil(arr, index + 1, current + arr.get(index));
        return Math.max(op1, op2);
    }

    private static boolean isValid(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if (++freq[val] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(maxLength(Arrays.asList("un", "iq", "ue")));
    }
}
