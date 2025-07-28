package dsquestions.strings;

import java.util.Stack;

public class MinRemoveValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            } else if (charArray[i] == ')') {
                if (stack.size() > 0) {
                    stack.pop();
                } else {
                    charArray[i] = '\0';
                }
            }
        }
        while (stack.size() > 0) {
            charArray[stack.pop()] = '\0';
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : charArray) {
            if (ch != '\0') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("))(("));
    }
}
