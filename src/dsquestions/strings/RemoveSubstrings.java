package dsquestions.strings;

import java.util.Stack;

public class RemoveSubstrings {

    public static String removeOccurrences(String s, String part) {

        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            stack.add(s.charAt(i));
            if (stack.size() >= part.length()) {
                int k = part.length();
                boolean match = true;
                for (int j = 0; j < k; j++) {
                    char stackChar = stack.get(stack.size() - k + j);
                    char patternChar = part.charAt(j);
                    if (stackChar != patternChar) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    int m = 0;
                    while (m < part.length()) {
                        stack.pop();
                        m++;
                    }
                }
            }

        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());

        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(removeOccurrences("ccctltctlltlb", "ctl"));
    }

}
