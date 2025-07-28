package dsquestions.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseSubstrings {

    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                List<Character> temp = new ArrayList<>();
                while (stack.peek() != '(') {
                    temp.add(stack.pop());
                }
                stack.pop();
                stack.addAll(temp);
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.peek());
        }
        return sb.toString();
    }

    public String reverseParentheses2(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(')
                stack.push(i);
            else if (currentChar == ')') {
                int start = stack.pop();
                reverse(result, start, result.length() - 1);
            } else result.append(currentChar);
        }
        return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(u(love)i)"));
    }
}
