package dsquestions.strings;

import java.util.Stack;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        String[] temp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String s1 : temp) {
            if (s1.trim().length() > 0) {
                stack.push(s1.trim());
            }
        }
        while (stack.size() > 0) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
