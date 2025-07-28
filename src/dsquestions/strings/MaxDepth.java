package dsquestions.strings;

public class MaxDepth {
    public static int maxDepth(String s) {
        if (s.isEmpty() || (s.length() == 1 && (s.charAt(0) != '(' || s.charAt(0) != ')'))) {
            return 0;
        }
        int temp = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                temp++;
                result = Math.max(result, temp);
            } else if (s.charAt(i) == ')') {
                temp--;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(maxDepth("()()"));


    }
}
